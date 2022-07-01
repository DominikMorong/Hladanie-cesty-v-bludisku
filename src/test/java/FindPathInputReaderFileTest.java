import static org.junit.jupiter.api.Assertions.*;

class FindPathInputReaderFileTest {

    FindPathInputReaderFile findPathInputReaderFile;
    String expected = "R,R,R,D,D,R,R,R,R,R,R,R,R,R,R,R,R,R,R,D,R,D,R,D,R,D,R,D,R,D,R,D,R,D,R,R,R,D,D,R,R,R,R,R,R,R,R,R,R,R,R,R,R,D,R,D,R,D,R,D,R,D,R,D,R,D,R,D";

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {findPathInputReaderFile = new FindPathInputReaderFile("src/main/resources/1.txt");
    }

    @org.junit.jupiter.api.Test
    void vypis() {assertEquals(expected, findPathInputReaderFile.vypis());
    }
}