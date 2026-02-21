package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mock.DiscountRepository;
import mock.PriceService;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    @Mock
    private DiscountRepository discountRepository;

    @Test
    void testCalculateFinalPrice_MOB() {
        
        PriceService priceService = new PriceService(discountRepository);
        when(discountRepository.getDiscountPercentage("MOB")).thenReturn(10.0);

        
        double result = priceService.calculateFinalPrice(1000, "MOB");

        
        assertEquals(900.0, result);
        verify(discountRepository).getDiscountPercentage("MOB");
    }

    @Test
    void testCalculateFinalPrice_LAP() {
        
        PriceService priceService = new PriceService(discountRepository);
        when(discountRepository.getDiscountPercentage("LAP")).thenReturn(20.0);

        double result = priceService.calculateFinalPrice(2000, "LAP");

        
        assertEquals(1600.0, result);
        verify(discountRepository).getDiscountPercentage("LAP");
    }


    @Test
    void testCalculateFinalPrice_Exception() {
        
        PriceService priceService = new PriceService(discountRepository);
        when(discountRepository.getDiscountPercentage("ERR"))
                .thenThrow(new RuntimeException("Repository error"));

      
        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> priceService.calculateFinalPrice(1000, "ERR"));

        assertEquals("Repository error", ex.getMessage());
        verify(discountRepository).getDiscountPercentage("ERR");
    }
}

