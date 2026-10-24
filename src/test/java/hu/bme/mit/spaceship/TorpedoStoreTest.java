package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        TorpedoStore store = new TorpedoStore(1);
        boolean result = store.fire(1);
        assertEquals(true, result);
    }

    @Test
    void check_empty() {
        TorpedoStore store = new TorpedoStore(0);
        boolean isEmpty = store.isEmpty();
        assertEquals(true, isEmpty);
    }

    @Test
    void check_torpedocount() {
        int numTorpedos = 42;
        TorpedoStore store = new TorpedoStore(numTorpedos);
        int torpedosStored = store.getTorpedoCount();
        assertEquals(numTorpedos, torpedosStored);
    }

    @Test
    void check_illegalArguments() {
        int numTorpedos = 42;
        TorpedoStore store = new TorpedoStore(numTorpedos);
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(numTorpedos + 1);
        });
    }

    @Test
    void fire_fail() {
        TorpedoStore store = new TorpedoStore(1, 1);
        boolean result = store.fire(1);
        assertEquals(false, result);
    }

    @Test
    void fire_success_lower_torpedocount() {
        TorpedoStore store = new TorpedoStore(1);
        store.fire(1);
        assertEquals(0, store.getTorpedoCount());
        assertEquals(true, store.isEmpty());
    }

}
