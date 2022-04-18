package ru.gb.lesson4;

public class BoxTest {
    Box box;
    @Nested
    class WhenEmpty {
        @BeforeEach
        void createEmptyBox(){
            box = new Box();
        }
        @Test
        void exeptionWhenTryToShuffleBoxTest() {
            Assertions.assertThrows(NullPointerException.class, () -> box.shuffleBalls());
        }

        @Test
        void addBallTest() {
            box.addBall();
            Assertions.assertEquals(box.getBallsCount(), 1);
        }
        @Nested
        class WhenOneBall {
            @BeforeEach
            void addBall() {
                box.addBall();
            }
            @Test
            void deleteBallTest() throws BoxIsAlreadyEmptyExeptions {
                box.deleteBall();
                Assertions.assertEquals(box.getBallsCount(), 0);
            }
        }
    }
}
