package GradeBook;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class GradebookTester {

    private GradeBook g1;
    private GradeBook g2;

    @Before
    public void setUp() {
        g1 = new GradeBook(5);
        g2 = new GradeBook(5);

        g1.addScore(50);
        g1.addScore(75);

        g2.addScore(80);
        g2.addScore(90);
        g2.addScore(100);
    }

    @After
    public void tearDown() {
        g1 = null;
        g2 = null;
    }

    @Test
    public void testAddScore() {
        assertTrue(g1.toString().equals("50.0 75.0 "));
        assertEquals(2, g1.getScoreSize());

        assertTrue(g2.toString().equals("80.0 90.0 100.0 "));
        assertEquals(3, g2.getScoreSize());

        assertTrue(g1.addScore(85));
        assertTrue(g1.toString().equals("50.0 75.0 85.0 "));
        assertEquals(3, g1.getScoreSize());
    }

    @Test
    public void testAddScoreWhenFull() {
        assertTrue(g1.addScore(85));
        assertTrue(g1.addScore(90));
        assertTrue(g1.addScore(95));

        assertFalse(g1.addScore(100));
        assertEquals(5, g1.getScoreSize());
        assertTrue(g1.toString().equals(
                "50.0 75.0 85.0 90.0 95.0 "));
    }

    @Test
    public void testGetScoreSize() {
        assertEquals(2, g1.getScoreSize());
        assertEquals(3, g2.getScoreSize());
    }

    @Test
    public void testToString() {
        assertEquals("50.0 75.0 ", g1.toString());
        assertEquals("80.0 90.0 100.0 ", g2.toString());
    }

    @Test
    public void testSum() {
        assertEquals(125.0, g1.sum(), 0.0001);
        assertEquals(270.0, g2.sum(), 0.0001);
    }

    @Test
    public void testMinimum() {
        assertEquals(50.0, g1.minimum(), 0.0001);
        assertEquals(80.0, g2.minimum(), 0.0001);
    }

    @Test
    public void testFinalScore() {
        assertEquals(75.0, g1.finalScore(), 0.0001);
        assertEquals(190.0, g2.finalScore(), 0.0001);
    }

    @Test
    public void testEmptyGradeBook() {
        GradeBook empty = new GradeBook(5);

        assertEquals(0, empty.getScoreSize());
        assertEquals("", empty.toString());
        assertEquals(0.0, empty.sum(), 0.0001);
        assertEquals(0.0, empty.minimum(), 0.0001);
        assertEquals(0.0, empty.finalScore(), 0.0001);
    }

    @Test
    public void testFinalScoreWithOneScore() {
        GradeBook single = new GradeBook(5);
        single.addScore(85);

        assertEquals(85.0, single.finalScore(), 0.0001);
    }
}