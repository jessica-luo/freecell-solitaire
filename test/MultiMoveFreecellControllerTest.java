import static org.junit.Assert.assertEquals;

import cs3500.freecell.controller.FreecellController;
import cs3500.freecell.controller.SimpleFreecellController;
import cs3500.freecell.model.hw02.ICard;
import cs3500.freecell.model.hw04.MultiMoveFreecellModel;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for the Controller using the MultiMoveFreecellModel (with mocks).
 */
public class MultiMoveFreecellControllerTest {

  MultiMoveFreecellModel model;
  List<ICard> reverse;

  @Before
  public void setUp() throws IllegalArgumentException {
    model = new MultiMoveFreecellModel();
    reverse = model.getDeck();
    Collections.reverse(reverse);
  }

  // multi move (too many cards moving, not enough empty piles, theres 0 empty piles and
  // trying to move 2 cards)
  @Test
  public void testMultiMoveTooManyCardsNotEnoughOpenPiles() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader(
        "c1 13 o1 c1 12 o2 c1 11 o3 c1 10 o4 c1 9 o5 c1 8 o6 c1 7 o7 c1 6 o8 c1 5 "
            + "o9 c1 4 o10 c1 3 o11 c1 2 o12 c2 13 o13 o1 1 c2 c1 1 o1 c4 13 f1 c4 12 "
            + "f1 c4 11 c1 c2 12 c1");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverse, 4, 13, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("O5:\n")
            .append("O6:\n").append("O7:\n").append("O8:\n").append("O9:\n").append("O10:\n")
            .append("O11:\n").append("O12:\n").append("O13:\n")
            .append("C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 13 to o1\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2:\n").append("O3:\n")
            .append("O4:\n").append("O5:\n").append("O6:\n").append("O7:\n").append("O8:\n")
            .append("O9:\n").append("O10:\n").append("O11:\n").append("O12:\n").append("O13:\n")
            .append("C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 12 to o2\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n").append("O3:\n")
            .append("O4:\n").append("O5:\n").append("O6:\n").append("O7:\n").append("O8:\n")
            .append("O9:\n").append("O10:\n").append("O11:\n").append("O12:\n").append("O13:\n")
            .append("C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 11 to o3\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4:\n").append("O5:\n").append("O6:\n").append("O7:\n")
            .append("O8:\n").append("O9:\n").append("O10:\n").append("O11:\n").append("O12:\n")
            .append("O13:\n").append("C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 10 to o4\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5:\n").append("O6:\n").append("O7:\n")
            .append("O8:\n").append("O9:\n").append("O10:\n").append("O11:\n").append("O12:\n")
            .append("O13:\n").append("C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 9 to o5\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6:\n")
            .append("O7:\n").append("O8:\n").append("O9:\n").append("O10:\n").append("O11:\n")
            .append("O12:\n").append("O13:\n").append("C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 8 to o6\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7:\n").append("O8:\n").append("O9:\n").append("O10:\n").append("O11:\n")
            .append("O12:\n").append("O13:\n").append("C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 7 to o7\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8:\n").append("O9:\n").append("O10:\n").append("O11:\n")
            .append("O12:\n").append("O13:\n").append("C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 6 to o8\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8: 8♠\n").append("O9:\n").append("O10:\n").append("O11:\n")
            .append("O12:\n").append("O13:\n").append("C1: K♠, Q♠, J♠, 10♠, 9♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 5 to o9\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8: 8♠\n").append("O9: 9♠\n").append("O10:\n")
            .append("O11:\n").append("O12:\n").append("O13:\n").append("C1: K♠, Q♠, J♠, 10♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 4 to o10\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8: 8♠\n").append("O9: 9♠\n").append("O10: 10♠\n")
            .append("O11:\n").append("O12:\n").append("O13:\n").append("C1: K♠, Q♠, J♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 3 to o11\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8: 8♠\n").append("O9: 9♠\n").append("O10: 10♠\n")
            .append("O11: J♠\n").append("O12:\n").append("O13:\n").append("C1: K♠, Q♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 2 to o12\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8: 8♠\n").append("O9: 9♠\n").append("O10: 10♠\n")
            .append("O11: J♠\n").append("O12: Q♠\n").append("O13:\n").append("C1: K♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c2 card number 13 to o13\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8: 8♠\n").append("O9: 9♠\n").append("O10: 10♠\n")
            .append("O11: J♠\n").append("O12: Q♠\n").append("O13: A♥\n").append("C1: K♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving o1 card number 1 to c2\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1:\n").append("O2: 2♠\n").append("O3: 3♠\n")
            .append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n").append("O7: 7♠\n")
            .append("O8: 8♠\n").append("O9: 9♠\n").append("O10: 10♠\n").append("O11: J♠\n")
            .append("O12: Q♠\n").append("O13: A♥\n").append("C1: K♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♠\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 1 to o1\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: K♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8: 8♠\n").append("O9: 9♠\n").append("O10: 10♠\n")
            .append("O11: J♠\n").append("O12: Q♠\n").append("O13: A♥\n").append("C1:\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♠\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c4 card number 13 to f1\n").append("F1: A♣\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: K♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8: 8♠\n").append("O9: 9♠\n").append("O10: 10♠\n")
            .append("O11: J♠\n").append("O12: Q♠\n").append("O13: A♥\n").append("C1:\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♠\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c4 card number 12 to f1\n").append("F1: A♣, 2♣\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: K♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8: 8♠\n").append("O9: 9♠\n").append("O10: 10♠\n")
            .append("O11: J♠\n").append("O12: Q♠\n").append("O13: A♥\n").append("C1:\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♠\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c4 card number 11 to c1\n").append("F1: A♣, 2♣\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: K♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8: 8♠\n").append("O9: 9♠\n").append("O10: 10♠\n")
            .append("O11: J♠\n").append("O12: Q♠\n").append("O13: A♥\n").append("C1: 3♣\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♠\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣\n").append("input card index\n")
            .append("input destination pile\n").append("Invalid move. Try again.\n").toString());
  }

  // multi move but build is invalid (incorrect value order)
  @Test
  public void testMovingIllegalStackRank() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("c1 9 o5 c1 8 o6 c1 7 o7 c1 6 o8 c1 5 "
        + "o9 c1 4 o10 c1 3 o11 c1 2 o12 c1 1 o13 c2 8 c1");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverse, 6, 16, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("O5:\n")
            .append("O6:\n").append("O7:\n").append("O8:\n").append("O9:\n").append("O10:\n")
            .append("O11:\n").append("O12:\n").append("O13:\n").append("O14:\n").append("O15:\n")
            .append("O16:\n").append("C1: K♠, Q♦, 10♠, 9♦, 7♠, 6♦, 4♠, 3♦, A♠\n")
            .append("C2: K♥, Q♣, 10♥, 9♣, 7♥, 6♣, 4♥, 3♣, A♥\n")
            .append("C3: K♦, J♠, 10♦, 8♠, 7♦, 5♠, 4♦, 2♠, A♦\n")
            .append("C4: K♣, J♥, 10♣, 8♥, 7♣, 5♥, 4♣, 2♥, A♣\n")
            .append("C5: Q♠, J♦, 9♠, 8♦, 6♠, 5♦, 3♠, 2♦\n")
            .append("C6: Q♥, J♣, 9♥, 8♣, 6♥, 5♣, 3♥, 2♣\n").append("input card index\n")
            .append("input destination pile\n").append("Moving c1 card number 9 to o5\n")
            .append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n").append("O1:\n")
            .append("O2:\n").append("O3:\n").append("O4:\n").append("O5: A♠\n").append("O6:\n")
            .append("O7:\n").append("O8:\n").append("O9:\n").append("O10:\n").append("O11:\n")
            .append("O12:\n").append("O13:\n").append("O14:\n").append("O15:\n").append("O16:\n")
            .append("C1: K♠, Q♦, 10♠, 9♦, 7♠, 6♦, 4♠, 3♦\n")
            .append("C2: K♥, Q♣, 10♥, 9♣, 7♥, 6♣, 4♥, 3♣, A♥\n")
            .append("C3: K♦, J♠, 10♦, 8♠, 7♦, 5♠, 4♦, 2♠, A♦\n")
            .append("C4: K♣, J♥, 10♣, 8♥, 7♣, 5♥, 4♣, 2♥, A♣\n")
            .append("C5: Q♠, J♦, 9♠, 8♦, 6♠, 5♦, 3♠, 2♦\n")
            .append("C6: Q♥, J♣, 9♥, 8♣, 6♥, 5♣, 3♥, 2♣\n").append("input card index\n")
            .append("input destination pile\n").append("Moving c1 card number 8 to o6\n")
            .append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n").append("O1:\n")
            .append("O2:\n").append("O3:\n").append("O4:\n").append("O5: A♠\n").append("O6: 3♦\n")
            .append("O7:\n").append("O8:\n").append("O9:\n").append("O10:\n").append("O11:\n")
            .append("O12:\n").append("O13:\n").append("O14:\n").append("O15:\n").append("O16:\n")
            .append("C1: K♠, Q♦, 10♠, 9♦, 7♠, 6♦, 4♠\n")
            .append("C2: K♥, Q♣, 10♥, 9♣, 7♥, 6♣, 4♥, 3♣, A♥\n")
            .append("C3: K♦, J♠, 10♦, 8♠, 7♦, 5♠, 4♦, 2♠, A♦\n")
            .append("C4: K♣, J♥, 10♣, 8♥, 7♣, 5♥, 4♣, 2♥, A♣\n")
            .append("C5: Q♠, J♦, 9♠, 8♦, 6♠, 5♦, 3♠, 2♦\n")
            .append("C6: Q♥, J♣, 9♥, 8♣, 6♥, 5♣, 3♥, 2♣\n").append("input card index\n")
            .append("input destination pile\n").append("Moving c1 card number 7 to o7\n")
            .append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n").append("O1:\n")
            .append("O2:\n").append("O3:\n").append("O4:\n").append("O5: A♠\n").append("O6: 3♦\n")
            .append("O7: 4♠\n").append("O8:\n").append("O9:\n").append("O10:\n").append("O11:\n")
            .append("O12:\n").append("O13:\n").append("O14:\n").append("O15:\n").append("O16:\n")
            .append("C1: K♠, Q♦, 10♠, 9♦, 7♠, 6♦\n")
            .append("C2: K♥, Q♣, 10♥, 9♣, 7♥, 6♣, 4♥, 3♣, A♥\n")
            .append("C3: K♦, J♠, 10♦, 8♠, 7♦, 5♠, 4♦, 2♠, A♦\n")
            .append("C4: K♣, J♥, 10♣, 8♥, 7♣, 5♥, 4♣, 2♥, A♣\n")
            .append("C5: Q♠, J♦, 9♠, 8♦, 6♠, 5♦, 3♠, 2♦\n")
            .append("C6: Q♥, J♣, 9♥, 8♣, 6♥, 5♣, 3♥, 2♣\n").append("input card index\n")
            .append("input destination pile\n").append("Moving c1 card number 6 to o8\n")
            .append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n").append("O1:\n")
            .append("O2:\n").append("O3:\n").append("O4:\n").append("O5: A♠\n").append("O6: 3♦\n")
            .append("O7: 4♠\n").append("O8: 6♦\n").append("O9:\n").append("O10:\n").append("O11:\n")
            .append("O12:\n").append("O13:\n").append("O14:\n").append("O15:\n").append("O16:\n")
            .append("C1: K♠, Q♦, 10♠, 9♦, 7♠\n").append("C2: K♥, Q♣, 10♥, 9♣, 7♥, 6♣, 4♥, 3♣, A♥\n")
            .append("C3: K♦, J♠, 10♦, 8♠, 7♦, 5♠, 4♦, 2♠, A♦\n")
            .append("C4: K♣, J♥, 10♣, 8♥, 7♣, 5♥, 4♣, 2♥, A♣\n")
            .append("C5: Q♠, J♦, 9♠, 8♦, 6♠, 5♦, 3♠, 2♦\n")
            .append("C6: Q♥, J♣, 9♥, 8♣, 6♥, 5♣, 3♥, 2♣\n").append("input card index\n")
            .append("input destination pile\n").append("Moving c1 card number 5 to o9\n")
            .append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n").append("O1:\n")
            .append("O2:\n").append("O3:\n").append("O4:\n").append("O5: A♠\n").append("O6: 3♦\n")
            .append("O7: 4♠\n").append("O8: 6♦\n").append("O9: 7♠\n").append("O10:\n")
            .append("O11:\n").append("O12:\n").append("O13:\n").append("O14:\n").append("O15:\n")
            .append("O16:\n").append("C1: K♠, Q♦, 10♠, 9♦\n")
            .append("C2: K♥, Q♣, 10♥, 9♣, 7♥, 6♣, 4♥, 3♣, A♥\n")
            .append("C3: K♦, J♠, 10♦, 8♠, 7♦, 5♠, 4♦, 2♠, A♦\n")
            .append("C4: K♣, J♥, 10♣, 8♥, 7♣, 5♥, 4♣, 2♥, A♣\n")
            .append("C5: Q♠, J♦, 9♠, 8♦, 6♠, 5♦, 3♠, 2♦\n")
            .append("C6: Q♥, J♣, 9♥, 8♣, 6♥, 5♣, 3♥, 2♣\n").append("input card index\n")
            .append("input destination pile\n").append("Moving c1 card number 4 to o10\n")
            .append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n").append("O1:\n")
            .append("O2:\n").append("O3:\n").append("O4:\n").append("O5: A♠\n").append("O6: 3♦\n")
            .append("O7: 4♠\n").append("O8: 6♦\n").append("O9: 7♠\n").append("O10: 9♦\n")
            .append("O11:\n").append("O12:\n").append("O13:\n").append("O14:\n").append("O15:\n")
            .append("O16:\n").append("C1: K♠, Q♦, 10♠\n")
            .append("C2: K♥, Q♣, 10♥, 9♣, 7♥, 6♣, 4♥, 3♣, A♥\n")
            .append("C3: K♦, J♠, 10♦, 8♠, 7♦, 5♠, 4♦, 2♠, A♦\n")
            .append("C4: K♣, J♥, 10♣, 8♥, 7♣, 5♥, 4♣, 2♥, A♣\n")
            .append("C5: Q♠, J♦, 9♠, 8♦, 6♠, 5♦, 3♠, 2♦\n")
            .append("C6: Q♥, J♣, 9♥, 8♣, 6♥, 5♣, 3♥, 2♣\n").append("input card index\n")
            .append("input destination pile\n").append("Moving c1 card number 3 to o11\n")
            .append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n").append("O1:\n")
            .append("O2:\n").append("O3:\n").append("O4:\n").append("O5: A♠\n").append("O6: 3♦\n")
            .append("O7: 4♠\n").append("O8: 6♦\n").append("O9: 7♠\n").append("O10: 9♦\n")
            .append("O11: 10♠\n").append("O12:\n").append("O13:\n").append("O14:\n")
            .append("O15:\n").append("O16:\n").append("C1: K♠, Q♦\n")
            .append("C2: K♥, Q♣, 10♥, 9♣, 7♥, 6♣, 4♥, 3♣, A♥\n")
            .append("C3: K♦, J♠, 10♦, 8♠, 7♦, 5♠, 4♦, 2♠, A♦\n")
            .append("C4: K♣, J♥, 10♣, 8♥, 7♣, 5♥, 4♣, 2♥, A♣\n")
            .append("C5: Q♠, J♦, 9♠, 8♦, 6♠, 5♦, 3♠, 2♦\n")
            .append("C6: Q♥, J♣, 9♥, 8♣, 6♥, 5♣, 3♥, 2♣\n").append("input card index\n")
            .append("input destination pile\n").append("Moving c1 card number 2 to o12\n")
            .append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n").append("O1:\n")
            .append("O2:\n").append("O3:\n").append("O4:\n").append("O5: A♠\n").append("O6: 3♦\n")
            .append("O7: 4♠\n").append("O8: 6♦\n").append("O9: 7♠\n").append("O10: 9♦\n")
            .append("O11: 10♠\n").append("O12: Q♦\n").append("O13:\n").append("O14:\n")
            .append("O15:\n").append("O16:\n").append("C1: K♠\n")
            .append("C2: K♥, Q♣, 10♥, 9♣, 7♥, 6♣, 4♥, 3♣, A♥\n")
            .append("C3: K♦, J♠, 10♦, 8♠, 7♦, 5♠, 4♦, 2♠, A♦\n")
            .append("C4: K♣, J♥, 10♣, 8♥, 7♣, 5♥, 4♣, 2♥, A♣\n")
            .append("C5: Q♠, J♦, 9♠, 8♦, 6♠, 5♦, 3♠, 2♦\n")
            .append("C6: Q♥, J♣, 9♥, 8♣, 6♥, 5♣, 3♥, 2♣\n").append("input card index\n")
            .append("input destination pile\n").append("Moving c1 card number 1 to o13\n")
            .append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n").append("O1:\n")
            .append("O2:\n").append("O3:\n").append("O4:\n").append("O5: A♠\n").append("O6: 3♦\n")
            .append("O7: 4♠\n").append("O8: 6♦\n").append("O9: 7♠\n").append("O10: 9♦\n")
            .append("O11: 10♠\n").append("O12: Q♦\n").append("O13: K♠\n").append("O14:\n")
            .append("O15:\n").append("O16:\n").append("C1:\n")
            .append("C2: K♥, Q♣, 10♥, 9♣, 7♥, 6♣, 4♥, 3♣, A♥\n")
            .append("C3: K♦, J♠, 10♦, 8♠, 7♦, 5♠, 4♦, 2♠, A♦\n")
            .append("C4: K♣, J♥, 10♣, 8♥, 7♣, 5♥, 4♣, 2♥, A♣\n")
            .append("C5: Q♠, J♦, 9♠, 8♦, 6♠, 5♦, 3♠, 2♦\n")
            .append("C6: Q♥, J♣, 9♥, 8♣, 6♥, 5♣, 3♥, 2♣\n").append("input card index\n")
            .append("input destination pile\n").append("Invalid move. Try again.\n").toString());
  }

  // multi move (correct values for build but incorrect color)
  @Test
  public void testMovingIllegalStackColor() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader(
        "c1 13 o1 c1 12 o2 c1 11 o3 c1 10 o4 c1 9 o5 c1 8 o6 c1 7 o7 c1 6 o8 c1 5 "
            + "o9 c1 4 o10 c1 3 o11 c1 2 o12 c1 1 o13 c2 12 c1");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(reverse, 4, 16, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("O5:\n")
            .append("O6:\n").append("O7:\n").append("O8:\n").append("O9:\n").append("O10:\n")
            .append("O11:\n").append("O12:\n").append("O13:\n").append("O14:\n").append("O15:\n")
            .append("O16:\n").append("C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠, A♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 13 to o1\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2:\n").append("O3:\n")
            .append("O4:\n").append("O5:\n").append("O6:\n").append("O7:\n").append("O8:\n")
            .append("O9:\n").append("O10:\n").append("O11:\n").append("O12:\n").append("O13:\n")
            .append("O14:\n").append("O15:\n").append("O16:\n")
            .append("C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠, 2♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 12 to o2\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n").append("O3:\n")
            .append("O4:\n").append("O5:\n").append("O6:\n").append("O7:\n").append("O8:\n")
            .append("O9:\n").append("O10:\n").append("O11:\n").append("O12:\n").append("O13:\n")
            .append("O14:\n").append("O15:\n").append("O16:\n")
            .append("C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠, 3♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 11 to o3\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4:\n").append("O5:\n").append("O6:\n").append("O7:\n")
            .append("O8:\n").append("O9:\n").append("O10:\n").append("O11:\n").append("O12:\n")
            .append("O13:\n").append("O14:\n").append("O15:\n").append("O16:\n")
            .append("C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠, 4♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 10 to o4\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5:\n").append("O6:\n").append("O7:\n")
            .append("O8:\n").append("O9:\n").append("O10:\n").append("O11:\n").append("O12:\n")
            .append("O13:\n").append("O14:\n").append("O15:\n").append("O16:\n")
            .append("C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠, 5♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 9 to o5\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6:\n")
            .append("O7:\n").append("O8:\n").append("O9:\n").append("O10:\n").append("O11:\n")
            .append("O12:\n").append("O13:\n").append("O14:\n").append("O15:\n").append("O16:\n")
            .append("C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠, 6♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 8 to o6\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7:\n").append("O8:\n").append("O9:\n").append("O10:\n").append("O11:\n")
            .append("O12:\n").append("O13:\n").append("O14:\n").append("O15:\n").append("O16:\n")
            .append("C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠, 7♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 7 to o7\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8:\n").append("O9:\n").append("O10:\n").append("O11:\n")
            .append("O12:\n").append("O13:\n").append("O14:\n").append("O15:\n").append("O16:\n")
            .append("C1: K♠, Q♠, J♠, 10♠, 9♠, 8♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 6 to o8\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8: 8♠\n").append("O9:\n").append("O10:\n").append("O11:\n")
            .append("O12:\n").append("O13:\n").append("O14:\n").append("O15:\n").append("O16:\n")
            .append("C1: K♠, Q♠, J♠, 10♠, 9♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 5 to o9\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8: 8♠\n").append("O9: 9♠\n").append("O10:\n")
            .append("O11:\n").append("O12:\n").append("O13:\n").append("O14:\n").append("O15:\n")
            .append("O16:\n").append("C1: K♠, Q♠, J♠, 10♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 4 to o10\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8: 8♠\n").append("O9: 9♠\n").append("O10: 10♠\n")
            .append("O11:\n").append("O12:\n").append("O13:\n").append("O14:\n").append("O15:\n")
            .append("O16:\n").append("C1: K♠, Q♠, J♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 3 to o11\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8: 8♠\n").append("O9: 9♠\n").append("O10: 10♠\n")
            .append("O11: J♠\n").append("O12:\n").append("O13:\n").append("O14:\n").append("O15:\n")
            .append("O16:\n").append("C1: K♠, Q♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 2 to o12\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8: 8♠\n").append("O9: 9♠\n").append("O10: 10♠\n")
            .append("O11: J♠\n").append("O12: Q♠\n").append("O13:\n").append("O14:\n")
            .append("O15:\n").append("O16:\n").append("C1: K♠\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 1 to o13\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♠\n").append("O2: 2♠\n")
            .append("O3: 3♠\n").append("O4: 4♠\n").append("O5: 5♠\n").append("O6: 6♠\n")
            .append("O7: 7♠\n").append("O8: 8♠\n").append("O9: 9♠\n").append("O10: 10♠\n")
            .append("O11: J♠\n").append("O12: Q♠\n").append("O13: K♠\n").append("O14:\n")
            .append("O15:\n").append("O16:\n").append("C1:\n")
            .append("C2: K♥, Q♥, J♥, 10♥, 9♥, 8♥, 7♥, 6♥, 5♥, 4♥, 3♥, 2♥, A♥\n")
            .append("C3: K♦, Q♦, J♦, 10♦, 9♦, 8♦, 7♦, 6♦, 5♦, 4♦, 3♦, 2♦, A♦\n")
            .append("C4: K♣, Q♣, J♣, 10♣, 9♣, 8♣, 7♣, 6♣, 5♣, 4♣, 3♣, 2♣, A♣\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Invalid move. Try again.\n").toString());
  }

  @Test
  public void illegalBuildRankMultiMovingValidStack() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("c1 1 c6 c6 1 c16");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 1 to c6\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1:\n").append("O2:\n").append("O3:\n")
            .append("O4:\n").append("C1:\n").append("C2: A♦\n").append("C3: A♥\n")
            .append("C4: A♠\n").append("C5: 2♣\n").append("C6: 2♦, A♣\n").append("C7: 2♥\n")
            .append("C8: 2♠\n").append("C9: 3♣\n").append("C10: 3♦\n").append("C11: 3♥\n")
            .append("C12: 3♠\n").append("C13: 4♣\n").append("C14: 4♦\n").append("C15: 4♥\n")
            .append("C16: 4♠\n").append("C17: 5♣\n").append("C18: 5♦\n").append("C19: 5♥\n")
            .append("C20: 5♠\n").append("C21: 6♣\n").append("C22: 6♦\n").append("C23: 6♥\n")
            .append("C24: 6♠\n").append("C25: 7♣\n").append("C26: 7♦\n").append("C27: 7♥\n")
            .append("C28: 7♠\n").append("C29: 8♣\n").append("C30: 8♦\n").append("C31: 8♥\n")
            .append("C32: 8♠\n").append("C33: 9♣\n").append("C34: 9♦\n").append("C35: 9♥\n")
            .append("C36: 9♠\n").append("C37: 10♣\n").append("C38: 10♦\n").append("C39: 10♥\n")
            .append("C40: 10♠\n").append("C41: J♣\n").append("C42: J♦\n").append("C43: J♥\n")
            .append("C44: J♠\n").append("C45: Q♣\n").append("C46: Q♦\n").append("C47: Q♥\n")
            .append("C48: Q♠\n").append("C49: K♣\n").append("C50: K♦\n").append("C51: K♥\n")
            .append("C52: K♠\n").append("input card index\n").append("input destination pile\n")
            .append("Invalid move. Try again.\n").toString());
  }

  @Test
  public void illegalBuildColorMultiMovingValidStack() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("c1 1 c6 c6 1 c10");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 1 to c6\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1:\n").append("O2:\n").append("O3:\n")
            .append("O4:\n").append("C1:\n").append("C2: A♦\n").append("C3: A♥\n")
            .append("C4: A♠\n").append("C5: 2♣\n").append("C6: 2♦, A♣\n").append("C7: 2♥\n")
            .append("C8: 2♠\n").append("C9: 3♣\n").append("C10: 3♦\n").append("C11: 3♥\n")
            .append("C12: 3♠\n").append("C13: 4♣\n").append("C14: 4♦\n").append("C15: 4♥\n")
            .append("C16: 4♠\n").append("C17: 5♣\n").append("C18: 5♦\n").append("C19: 5♥\n")
            .append("C20: 5♠\n").append("C21: 6♣\n").append("C22: 6♦\n").append("C23: 6♥\n")
            .append("C24: 6♠\n").append("C25: 7♣\n").append("C26: 7♦\n").append("C27: 7♥\n")
            .append("C28: 7♠\n").append("C29: 8♣\n").append("C30: 8♦\n").append("C31: 8♥\n")
            .append("C32: 8♠\n").append("C33: 9♣\n").append("C34: 9♦\n").append("C35: 9♥\n")
            .append("C36: 9♠\n").append("C37: 10♣\n").append("C38: 10♦\n").append("C39: 10♥\n")
            .append("C40: 10♠\n").append("C41: J♣\n").append("C42: J♦\n").append("C43: J♥\n")
            .append("C44: J♠\n").append("C45: Q♣\n").append("C46: Q♦\n").append("C47: Q♥\n")
            .append("C48: Q♠\n").append("C49: K♣\n").append("C50: K♦\n").append("C51: K♥\n")
            .append("C52: K♠\n").append("input card index\n").append("input destination pile\n")
            .append("Invalid move. Try again.\n").toString());
  }

  @Test
  public void multiMove4Cards() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("c1 1 c6 c6 1 c9 c9 1 c14 c14 1 c17");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 1 to c6\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1:\n").append("O2:\n").append("O3:\n")
            .append("O4:\n").append("C1:\n").append("C2: A♦\n").append("C3: A♥\n")
            .append("C4: A♠\n").append("C5: 2♣\n").append("C6: 2♦, A♣\n").append("C7: 2♥\n")
            .append("C8: 2♠\n").append("C9: 3♣\n").append("C10: 3♦\n").append("C11: 3♥\n")
            .append("C12: 3♠\n").append("C13: 4♣\n").append("C14: 4♦\n").append("C15: 4♥\n")
            .append("C16: 4♠\n").append("C17: 5♣\n").append("C18: 5♦\n").append("C19: 5♥\n")
            .append("C20: 5♠\n").append("C21: 6♣\n").append("C22: 6♦\n").append("C23: 6♥\n")
            .append("C24: 6♠\n").append("C25: 7♣\n").append("C26: 7♦\n").append("C27: 7♥\n")
            .append("C28: 7♠\n").append("C29: 8♣\n").append("C30: 8♦\n").append("C31: 8♥\n")
            .append("C32: 8♠\n").append("C33: 9♣\n").append("C34: 9♦\n").append("C35: 9♥\n")
            .append("C36: 9♠\n").append("C37: 10♣\n").append("C38: 10♦\n").append("C39: 10♥\n")
            .append("C40: 10♠\n").append("C41: J♣\n").append("C42: J♦\n").append("C43: J♥\n")
            .append("C44: J♠\n").append("C45: Q♣\n").append("C46: Q♦\n").append("C47: Q♥\n")
            .append("C48: Q♠\n").append("C49: K♣\n").append("C50: K♦\n").append("C51: K♥\n")
            .append("C52: K♠\n").append("input card index\n").append("input destination pile\n")
            .append("Moving c6 card number 1 to c9\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1:\n").append("O2:\n").append("O3:\n")
            .append("O4:\n").append("C1:\n").append("C2: A♦\n").append("C3: A♥\n")
            .append("C4: A♠\n").append("C5: 2♣\n").append("C6:\n").append("C7: 2♥\n")
            .append("C8: 2♠\n").append("C9: 3♣, 2♦, A♣\n").append("C10: 3♦\n").append("C11: 3♥\n")
            .append("C12: 3♠\n").append("C13: 4♣\n").append("C14: 4♦\n").append("C15: 4♥\n")
            .append("C16: 4♠\n").append("C17: 5♣\n").append("C18: 5♦\n").append("C19: 5♥\n")
            .append("C20: 5♠\n").append("C21: 6♣\n").append("C22: 6♦\n").append("C23: 6♥\n")
            .append("C24: 6♠\n").append("C25: 7♣\n").append("C26: 7♦\n").append("C27: 7♥\n")
            .append("C28: 7♠\n").append("C29: 8♣\n").append("C30: 8♦\n").append("C31: 8♥\n")
            .append("C32: 8♠\n").append("C33: 9♣\n").append("C34: 9♦\n").append("C35: 9♥\n")
            .append("C36: 9♠\n").append("C37: 10♣\n").append("C38: 10♦\n").append("C39: 10♥\n")
            .append("C40: 10♠\n").append("C41: J♣\n").append("C42: J♦\n").append("C43: J♥\n")
            .append("C44: J♠\n").append("C45: Q♣\n").append("C46: Q♦\n").append("C47: Q♥\n")
            .append("C48: Q♠\n").append("C49: K♣\n").append("C50: K♦\n").append("C51: K♥\n")
            .append("C52: K♠\n").append("input card index\n").append("input destination pile\n")
            .append("Moving c9 card number 1 to c14\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1:\n").append("O2:\n").append("O3:\n")
            .append("O4:\n").append("C1:\n").append("C2: A♦\n").append("C3: A♥\n")
            .append("C4: A♠\n").append("C5: 2♣\n").append("C6:\n").append("C7: 2♥\n")
            .append("C8: 2♠\n").append("C9:\n").append("C10: 3♦\n").append("C11: 3♥\n")
            .append("C12: 3♠\n").append("C13: 4♣\n").append("C14: 4♦, 3♣, 2♦, A♣\n")
            .append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n").append("C18: 5♦\n")
            .append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n").append("C22: 6♦\n")
            .append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n").append("C26: 7♦\n")
            .append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n").append("C30: 8♦\n")
            .append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n").append("C34: 9♦\n")
            .append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n").append("C38: 10♦\n")
            .append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n").append("C42: J♦\n")
            .append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n").append("C46: Q♦\n")
            .append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n").append("C50: K♦\n")
            .append("C51: K♥\n").append("C52: K♠\n").append("input card index\n")
            .append("input destination pile\n").append("Moving c14 card number 1 to c17\n")
            .append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n").append("O1:\n")
            .append("O2:\n").append("O3:\n").append("O4:\n").append("C1:\n").append("C2: A♦\n")
            .append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n").append("C6:\n")
            .append("C7: 2♥\n").append("C8: 2♠\n").append("C9:\n").append("C10: 3♦\n")
            .append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n").append("C14:\n")
            .append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣, 4♦, 3♣, 2♦, A♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n").toString());
  }

  @Test
  public void multiMove3Cards() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("c1 1 c6 c6 1 c9 c9 1 c14");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 1 to c6\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1:\n").append("O2:\n").append("O3:\n")
            .append("O4:\n").append("C1:\n").append("C2: A♦\n").append("C3: A♥\n")
            .append("C4: A♠\n").append("C5: 2♣\n").append("C6: 2♦, A♣\n").append("C7: 2♥\n")
            .append("C8: 2♠\n").append("C9: 3♣\n").append("C10: 3♦\n").append("C11: 3♥\n")
            .append("C12: 3♠\n").append("C13: 4♣\n").append("C14: 4♦\n").append("C15: 4♥\n")
            .append("C16: 4♠\n").append("C17: 5♣\n").append("C18: 5♦\n").append("C19: 5♥\n")
            .append("C20: 5♠\n").append("C21: 6♣\n").append("C22: 6♦\n").append("C23: 6♥\n")
            .append("C24: 6♠\n").append("C25: 7♣\n").append("C26: 7♦\n").append("C27: 7♥\n")
            .append("C28: 7♠\n").append("C29: 8♣\n").append("C30: 8♦\n").append("C31: 8♥\n")
            .append("C32: 8♠\n").append("C33: 9♣\n").append("C34: 9♦\n").append("C35: 9♥\n")
            .append("C36: 9♠\n").append("C37: 10♣\n").append("C38: 10♦\n").append("C39: 10♥\n")
            .append("C40: 10♠\n").append("C41: J♣\n").append("C42: J♦\n").append("C43: J♥\n")
            .append("C44: J♠\n").append("C45: Q♣\n").append("C46: Q♦\n").append("C47: Q♥\n")
            .append("C48: Q♠\n").append("C49: K♣\n").append("C50: K♦\n").append("C51: K♥\n")
            .append("C52: K♠\n").append("input card index\n").append("input destination pile\n")
            .append("Moving c6 card number 1 to c9\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1:\n").append("O2:\n").append("O3:\n")
            .append("O4:\n").append("C1:\n").append("C2: A♦\n").append("C3: A♥\n")
            .append("C4: A♠\n").append("C5: 2♣\n").append("C6:\n").append("C7: 2♥\n")
            .append("C8: 2♠\n").append("C9: 3♣, 2♦, A♣\n").append("C10: 3♦\n").append("C11: 3♥\n")
            .append("C12: 3♠\n").append("C13: 4♣\n").append("C14: 4♦\n").append("C15: 4♥\n")
            .append("C16: 4♠\n").append("C17: 5♣\n").append("C18: 5♦\n").append("C19: 5♥\n")
            .append("C20: 5♠\n").append("C21: 6♣\n").append("C22: 6♦\n").append("C23: 6♥\n")
            .append("C24: 6♠\n").append("C25: 7♣\n").append("C26: 7♦\n").append("C27: 7♥\n")
            .append("C28: 7♠\n").append("C29: 8♣\n").append("C30: 8♦\n").append("C31: 8♥\n")
            .append("C32: 8♠\n").append("C33: 9♣\n").append("C34: 9♦\n").append("C35: 9♥\n")
            .append("C36: 9♠\n").append("C37: 10♣\n").append("C38: 10♦\n").append("C39: 10♥\n")
            .append("C40: 10♠\n").append("C41: J♣\n").append("C42: J♦\n").append("C43: J♥\n")
            .append("C44: J♠\n").append("C45: Q♣\n").append("C46: Q♦\n").append("C47: Q♥\n")
            .append("C48: Q♠\n").append("C49: K♣\n").append("C50: K♦\n").append("C51: K♥\n")
            .append("C52: K♠\n").append("input card index\n").append("input destination pile\n")
            .append("Moving c9 card number 1 to c14\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1:\n").append("O2:\n").append("O3:\n")
            .append("O4:\n").append("C1:\n").append("C2: A♦\n").append("C3: A♥\n")
            .append("C4: A♠\n").append("C5: 2♣\n").append("C6:\n").append("C7: 2♥\n")
            .append("C8: 2♠\n").append("C9:\n").append("C10: 3♦\n").append("C11: 3♥\n")
            .append("C12: 3♠\n").append("C13: 4♣\n").append("C14: 4♦, 3♣, 2♦, A♣\n")
            .append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n").append("C18: 5♦\n")
            .append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n").append("C22: 6♦\n")
            .append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n").append("C26: 7♦\n")
            .append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n").append("C30: 8♦\n")
            .append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n").append("C34: 9♦\n")
            .append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n").append("C38: 10♦\n")
            .append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n").append("C42: J♦\n")
            .append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n").append("C46: Q♦\n")
            .append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n").append("C50: K♦\n")
            .append("C51: K♥\n").append("C52: K♠\n").toString());
  }

  @Test
  public void multiMove2Cards() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("c1 1 c6 c6 1 c9");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 1 to c6\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1:\n").append("O2:\n").append("O3:\n")
            .append("O4:\n").append("C1:\n").append("C2: A♦\n").append("C3: A♥\n")
            .append("C4: A♠\n").append("C5: 2♣\n").append("C6: 2♦, A♣\n").append("C7: 2♥\n")
            .append("C8: 2♠\n").append("C9: 3♣\n").append("C10: 3♦\n").append("C11: 3♥\n")
            .append("C12: 3♠\n").append("C13: 4♣\n").append("C14: 4♦\n").append("C15: 4♥\n")
            .append("C16: 4♠\n").append("C17: 5♣\n").append("C18: 5♦\n").append("C19: 5♥\n")
            .append("C20: 5♠\n").append("C21: 6♣\n").append("C22: 6♦\n").append("C23: 6♥\n")
            .append("C24: 6♠\n").append("C25: 7♣\n").append("C26: 7♦\n").append("C27: 7♥\n")
            .append("C28: 7♠\n").append("C29: 8♣\n").append("C30: 8♦\n").append("C31: 8♥\n")
            .append("C32: 8♠\n").append("C33: 9♣\n").append("C34: 9♦\n").append("C35: 9♥\n")
            .append("C36: 9♠\n").append("C37: 10♣\n").append("C38: 10♦\n").append("C39: 10♥\n")
            .append("C40: 10♠\n").append("C41: J♣\n").append("C42: J♦\n").append("C43: J♥\n")
            .append("C44: J♠\n").append("C45: Q♣\n").append("C46: Q♦\n").append("C47: Q♥\n")
            .append("C48: Q♠\n").append("C49: K♣\n").append("C50: K♦\n").append("C51: K♥\n")
            .append("C52: K♠\n").append("input card index\n").append("input destination pile\n")
            .append("Moving c6 card number 1 to c9\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1:\n").append("O2:\n").append("O3:\n")
            .append("O4:\n").append("C1:\n").append("C2: A♦\n").append("C3: A♥\n")
            .append("C4: A♠\n").append("C5: 2♣\n").append("C6:\n").append("C7: 2♥\n")
            .append("C8: 2♠\n").append("C9: 3♣, 2♦, A♣\n").append("C10: 3♦\n").append("C11: 3♥\n")
            .append("C12: 3♠\n").append("C13: 4♣\n").append("C14: 4♦\n").append("C15: 4♥\n")
            .append("C16: 4♠\n").append("C17: 5♣\n").append("C18: 5♦\n").append("C19: 5♥\n")
            .append("C20: 5♠\n").append("C21: 6♣\n").append("C22: 6♦\n").append("C23: 6♥\n")
            .append("C24: 6♠\n").append("C25: 7♣\n").append("C26: 7♦\n").append("C27: 7♥\n")
            .append("C28: 7♠\n").append("C29: 8♣\n").append("C30: 8♦\n").append("C31: 8♥\n")
            .append("C32: 8♠\n").append("C33: 9♣\n").append("C34: 9♦\n").append("C35: 9♥\n")
            .append("C36: 9♠\n").append("C37: 10♣\n").append("C38: 10♦\n").append("C39: 10♥\n")
            .append("C40: 10♠\n").append("C41: J♣\n").append("C42: J♦\n").append("C43: J♥\n")
            .append("C44: J♠\n").append("C45: Q♣\n").append("C46: Q♦\n").append("C47: Q♥\n")
            .append("C48: Q♠\n").append("C49: K♣\n").append("C50: K♦\n").append("C51: K♥\n")
            .append("C52: K♠\n").toString());
  }

  @Test
  public void invalidCascadeMove() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("c2 1 c1");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 4, 1, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n")
            .append("C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n")
            .append("C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n")
            .append("C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Invalid move. Try again.\n").toString());
  }

  @Test
  public void invalidCardIndexInput() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("o2 1 o1");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 4, 1, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n")
            .append("C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n")
            .append("C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n")
            .append("C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Invalid move. Try again.\n").toString());
  }

  @Test
  public void invalidIndexForNumberOfSourcePiles() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("c5 1 o1");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 4, 1, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("C1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n")
            .append("C2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n")
            .append("C3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n")
            .append("C4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Invalid move. Try again.\n").toString());
  }

  @Test
  public void shuffleDeckTrueStartGame() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(new ArrayList(), 52, 1, true);

    assertEquals(out.toString().equals(
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n").toString()), false);
  }

  @Test
  public void illegalDeckStartGame() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(new ArrayList(), 52, 0, false);

    assertEquals(out.toString(), "Could not start game.");
  }

  @Test
  public void illegalDeckStartGameShuffle() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(new ArrayList(), 52, 0, true);

    assertEquals(out.toString(), "Could not start game.");
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullDeckPlayGame() {
    new SimpleFreecellController(model, new StringReader("cewe"), new AppendableForTest())
        .playGame(null, 52, 4, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullModelInControllerConstructor() {
    new SimpleFreecellController(null, new StringReader(""), new AppendableForTest());
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullReadableInControllerConstructor() {
    new SimpleFreecellController(model, null, new StringBuilder());
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullAppendableInControllerConstructor() {
    new SimpleFreecellController(model, new StringReader(""), null);
  }

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  @Test
  public void ranOutOfReadable() {
    expectedEx.expect(IllegalStateException.class);
    expectedEx.expectMessage("failed to read");

    SimpleFreecellController controller = new SimpleFreecellController(model, new StringReader(""),
        new StringBuilder());
    controller.playGame(model.getDeck(), 4, 4, true);
  }

  @Test
  public void playGameCouldNotAppendToAppendable() {
    expectedEx.expect(IllegalStateException.class);
    expectedEx.expectMessage("failed to write to appendable");

    SimpleFreecellController controller = new SimpleFreecellController(model, new StringReader(""),
        new AppendableForTest());
    controller.playGame(model.getDeck(), 4, 4, true);
  }

  @Test
  public void couldNotStartGameOpenPilesIllegal() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 0, false);

    assertEquals(out.toString(), "Could not start game.");
  }

  @Test
  public void couldNotStartGame() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 0, 4, false);

    assertEquals(out.toString(), "Could not start game.");
  }

  @Test
  public void invalidMoveFromFoundation() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("c1 1 f1 f1 1 c1");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 1 to f1\n").append("F1: A♣\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1:\n").append("O2:\n").append("O3:\n")
            .append("O4:\n").append("C1:\n").append("C2: A♦\n").append("C3: A♥\n")
            .append("C4: A♠\n").append("C5: 2♣\n").append("C6: 2♦\n").append("C7: 2♥\n")
            .append("C8: 2♠\n").append("C9: 3♣\n").append("C10: 3♦\n").append("C11: 3♥\n")
            .append("C12: 3♠\n").append("C13: 4♣\n").append("C14: 4♦\n").append("C15: 4♥\n")
            .append("C16: 4♠\n").append("C17: 5♣\n").append("C18: 5♦\n").append("C19: 5♥\n")
            .append("C20: 5♠\n").append("C21: 6♣\n").append("C22: 6♦\n").append("C23: 6♥\n")
            .append("C24: 6♠\n").append("C25: 7♣\n").append("C26: 7♦\n").append("C27: 7♥\n")
            .append("C28: 7♠\n").append("C29: 8♣\n").append("C30: 8♦\n").append("C31: 8♥\n")
            .append("C32: 8♠\n").append("C33: 9♣\n").append("C34: 9♦\n").append("C35: 9♥\n")
            .append("C36: 9♠\n").append("C37: 10♣\n").append("C38: 10♦\n").append("C39: 10♥\n")
            .append("C40: 10♠\n").append("C41: J♣\n").append("C42: J♦\n").append("C43: J♥\n")
            .append("C44: J♠\n").append("C45: Q♣\n").append("C46: Q♦\n").append("C47: Q♥\n")
            .append("C48: Q♠\n").append("C49: K♣\n").append("C50: K♦\n").append("C51: K♥\n")
            .append("C52: K♠\n").append("input card index\n").append("input destination pile\n")
            .append("Invalid move. Try again.\n").toString());
  }

  @Test
  public void moveOpenToFoundation() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("c1 1 o1 o1 1 f1");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 1 to o1\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♣\n").append("O2:\n").append("O3:\n")
            .append("O4:\n").append("C1:\n").append("C2: A♦\n").append("C3: A♥\n")
            .append("C4: A♠\n").append("C5: 2♣\n").append("C6: 2♦\n").append("C7: 2♥\n")
            .append("C8: 2♠\n").append("C9: 3♣\n").append("C10: 3♦\n").append("C11: 3♥\n")
            .append("C12: 3♠\n").append("C13: 4♣\n").append("C14: 4♦\n").append("C15: 4♥\n")
            .append("C16: 4♠\n").append("C17: 5♣\n").append("C18: 5♦\n").append("C19: 5♥\n")
            .append("C20: 5♠\n").append("C21: 6♣\n").append("C22: 6♦\n").append("C23: 6♥\n")
            .append("C24: 6♠\n").append("C25: 7♣\n").append("C26: 7♦\n").append("C27: 7♥\n")
            .append("C28: 7♠\n").append("C29: 8♣\n").append("C30: 8♦\n").append("C31: 8♥\n")
            .append("C32: 8♠\n").append("C33: 9♣\n").append("C34: 9♦\n").append("C35: 9♥\n")
            .append("C36: 9♠\n").append("C37: 10♣\n").append("C38: 10♦\n").append("C39: 10♥\n")
            .append("C40: 10♠\n").append("C41: J♣\n").append("C42: J♦\n").append("C43: J♥\n")
            .append("C44: J♠\n").append("C45: Q♣\n").append("C46: Q♦\n").append("C47: Q♥\n")
            .append("C48: Q♠\n").append("C49: K♣\n").append("C50: K♦\n").append("C51: K♥\n")
            .append("C52: K♠\n").append("input card index\n").append("input destination pile\n")
            .append("Moving o1 card number 1 to f1\n").append("F1: A♣\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1:\n").append("O2:\n").append("O3:\n")
            .append("O4:\n").append("C1:\n").append("C2: A♦\n").append("C3: A♥\n")
            .append("C4: A♠\n").append("C5: 2♣\n").append("C6: 2♦\n").append("C7: 2♥\n")
            .append("C8: 2♠\n").append("C9: 3♣\n").append("C10: 3♦\n").append("C11: 3♥\n")
            .append("C12: 3♠\n").append("C13: 4♣\n").append("C14: 4♦\n").append("C15: 4♥\n")
            .append("C16: 4♠\n").append("C17: 5♣\n").append("C18: 5♦\n").append("C19: 5♥\n")
            .append("C20: 5♠\n").append("C21: 6♣\n").append("C22: 6♦\n").append("C23: 6♥\n")
            .append("C24: 6♠\n").append("C25: 7♣\n").append("C26: 7♦\n").append("C27: 7♥\n")
            .append("C28: 7♠\n").append("C29: 8♣\n").append("C30: 8♦\n").append("C31: 8♥\n")
            .append("C32: 8♠\n").append("C33: 9♣\n").append("C34: 9♦\n").append("C35: 9♥\n")
            .append("C36: 9♠\n").append("C37: 10♣\n").append("C38: 10♦\n").append("C39: 10♥\n")
            .append("C40: 10♠\n").append("C41: J♣\n").append("C42: J♦\n").append("C43: J♥\n")
            .append("C44: J♠\n").append("C45: Q♣\n").append("C46: Q♦\n").append("C47: Q♥\n")
            .append("C48: Q♠\n").append("C49: K♣\n").append("C50: K♦\n").append("C51: K♥\n")
            .append("C52: K♠\n").toString());
  }

  @Test
  public void moveCascadeToOpen() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("C1 1 O1 q");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 1 to o1\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1: A♣\n").append("O2:\n").append("O3:\n")
            .append("O4:\n").append("C1:\n").append("C2: A♦\n").append("C3: A♥\n")
            .append("C4: A♠\n").append("C5: 2♣\n").append("C6: 2♦\n").append("C7: 2♥\n")
            .append("C8: 2♠\n").append("C9: 3♣\n").append("C10: 3♦\n").append("C11: 3♥\n")
            .append("C12: 3♠\n").append("C13: 4♣\n").append("C14: 4♦\n").append("C15: 4♥\n")
            .append("C16: 4♠\n").append("C17: 5♣\n").append("C18: 5♦\n").append("C19: 5♥\n")
            .append("C20: 5♠\n").append("C21: 6♣\n").append("C22: 6♦\n").append("C23: 6♥\n")
            .append("C24: 6♠\n").append("C25: 7♣\n").append("C26: 7♦\n").append("C27: 7♥\n")
            .append("C28: 7♠\n").append("C29: 8♣\n").append("C30: 8♦\n").append("C31: 8♥\n")
            .append("C32: 8♠\n").append("C33: 9♣\n").append("C34: 9♦\n").append("C35: 9♥\n")
            .append("C36: 9♠\n").append("C37: 10♣\n").append("C38: 10♦\n").append("C39: 10♥\n")
            .append("C40: 10♠\n").append("C41: J♣\n").append("C42: J♦\n").append("C43: J♥\n")
            .append("C44: J♠\n").append("C45: Q♣\n").append("C46: Q♦\n").append("C47: Q♥\n")
            .append("C48: Q♠\n").append("C49: K♣\n").append("C50: K♦\n").append("C51: K♥\n")
            .append("C52: K♠\n").append("Game quit prematurely.\n").toString());
  }

  @Test
  public void quitGameImmediatelyAndInvalidSourcePileInput() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("c3e Q");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("Invalid source pile. Try again.\n").append("Game quit prematurely.\n")
            .toString());
  }

  @Test
  public void quitGameAfterValidSourcePileInput() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("c1 q");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("input card index\n").append("Game quit prematurely.\n").toString());
  }

  @Test
  public void multipleInvalidCardIndexInputAndQuitGameAfter() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("c1 f r44dde q");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("input card index\n").append("Invalid card index. Try again.\n")
            .append("Invalid card index. Try again.\n").append("Game quit prematurely.\n")
            .toString());
  }

  @Test
  public void quitForCardIndex() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("c1 q");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("input card index\n").append("Game quit prematurely.\n").toString());
  }

  @Test
  public void invalidDestPileInputAndQuitAfter() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("c1 f r44dde 1 f Q");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("input card index\n").append("Invalid card index. Try again.\n")
            .append("Invalid card index. Try again.\n").append("input destination pile\n")
            .append("Invalid destination pile. Try again.\n").append("Game quit prematurely.\n")
            .toString());
  }

  @Test
  public void quitForDestPileInput() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("c1 1 Q");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Game quit prematurely.\n").toString());
  }

  @Test
  public void successfulMoveAndQuitAfter() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("c1 1 O2 Q");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Moving c1 card number 1 to o2\n").append("F1:\n").append("F2:\n")
            .append("F3:\n").append("F4:\n").append("O1:\n").append("O2: A♣\n").append("O3:\n")
            .append("O4:\n").append("C1:\n").append("C2: A♦\n").append("C3: A♥\n")
            .append("C4: A♠\n").append("C5: 2♣\n").append("C6: 2♦\n").append("C7: 2♥\n")
            .append("C8: 2♠\n").append("C9: 3♣\n").append("C10: 3♦\n").append("C11: 3♥\n")
            .append("C12: 3♠\n").append("C13: 4♣\n").append("C14: 4♦\n").append("C15: 4♥\n")
            .append("C16: 4♠\n").append("C17: 5♣\n").append("C18: 5♦\n").append("C19: 5♥\n")
            .append("C20: 5♠\n").append("C21: 6♣\n").append("C22: 6♦\n").append("C23: 6♥\n")
            .append("C24: 6♠\n").append("C25: 7♣\n").append("C26: 7♦\n").append("C27: 7♥\n")
            .append("C28: 7♠\n").append("C29: 8♣\n").append("C30: 8♦\n").append("C31: 8♥\n")
            .append("C32: 8♠\n").append("C33: 9♣\n").append("C34: 9♦\n").append("C35: 9♥\n")
            .append("C36: 9♠\n").append("C37: 10♣\n").append("C38: 10♦\n").append("C39: 10♥\n")
            .append("C40: 10♠\n").append("C41: J♣\n").append("C42: J♦\n").append("C43: J♥\n")
            .append("C44: J♠\n").append("C45: Q♣\n").append("C46: Q♦\n").append("C47: Q♥\n")
            .append("C48: Q♠\n").append("C49: K♣\n").append("C50: K♦\n").append("C51: K♥\n")
            .append("C52: K♠\n").append("Game quit prematurely.\n").toString());
  }

  @Test
  public void unsuccessfulMove() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("F4 1 C4");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Invalid move. Try again.\n").toString());
  }

  @Test
  public void unsuccessfulMoveFollowedBySuccessfulMove() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("F4 1 C4 c1 1 O2");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("input card index\n").append("input destination pile\n")
            .append("Invalid move. Try again.\n").append("input card index\n")
            .append("input destination pile\n").append("Moving c1 card number 1 to o2\n")
            .append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n").append("O1:\n")
            .append("O2: A♣\n").append("O3:\n").append("O4:\n").append("C1:\n").append("C2: A♦\n")
            .append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n").append("C6: 2♦\n")
            .append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n").append("C10: 3♦\n")
            .append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n").append("C14: 4♦\n")
            .append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n").append("C18: 5♦\n")
            .append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n").append("C22: 6♦\n")
            .append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n").append("C26: 7♦\n")
            .append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n").append("C30: 8♦\n")
            .append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n").append("C34: 9♦\n")
            .append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n").append("C38: 10♦\n")
            .append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n").append("C42: J♦\n")
            .append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n").append("C46: Q♦\n")
            .append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n").append("C50: K♦\n")
            .append("C51: K♥\n").append("C52: K♠\n").toString());
  }

  @Test
  public void quitImmediately() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader("q");
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(),
        new StringBuilder().append("F1:\n").append("F2:\n").append("F3:\n").append("F4:\n")
            .append("O1:\n").append("O2:\n").append("O3:\n").append("O4:\n").append("C1: A♣\n")
            .append("C2: A♦\n").append("C3: A♥\n").append("C4: A♠\n").append("C5: 2♣\n")
            .append("C6: 2♦\n").append("C7: 2♥\n").append("C8: 2♠\n").append("C9: 3♣\n")
            .append("C10: 3♦\n").append("C11: 3♥\n").append("C12: 3♠\n").append("C13: 4♣\n")
            .append("C14: 4♦\n").append("C15: 4♥\n").append("C16: 4♠\n").append("C17: 5♣\n")
            .append("C18: 5♦\n").append("C19: 5♥\n").append("C20: 5♠\n").append("C21: 6♣\n")
            .append("C22: 6♦\n").append("C23: 6♥\n").append("C24: 6♠\n").append("C25: 7♣\n")
            .append("C26: 7♦\n").append("C27: 7♥\n").append("C28: 7♠\n").append("C29: 8♣\n")
            .append("C30: 8♦\n").append("C31: 8♥\n").append("C32: 8♠\n").append("C33: 9♣\n")
            .append("C34: 9♦\n").append("C35: 9♥\n").append("C36: 9♠\n").append("C37: 10♣\n")
            .append("C38: 10♦\n").append("C39: 10♥\n").append("C40: 10♠\n").append("C41: J♣\n")
            .append("C42: J♦\n").append("C43: J♥\n").append("C44: J♠\n").append("C45: Q♣\n")
            .append("C46: Q♦\n").append("C47: Q♥\n").append("C48: Q♠\n").append("C49: K♣\n")
            .append("C50: K♦\n").append("C51: K♥\n").append("C52: K♠\n")
            .append("Game quit prematurely.\n").toString());
  }

  @Test
  public void testGameOverMultiMove() {
    Appendable out = new StringBuilder();
    Readable in = new StringReader(
        new StringBuilder().append("c5 1 c10 c10 1 c16 c16 3 c5 c16 2 c10 ").append("c C1 1 f1\n")
            .append("C5 1 f1\n").append("C9 1 f1\n")
            .append("C13 1 f1\n").append("C17 1 f1\n").append("C21 1 f1\n").append("C25 1 f1\n")
            .append("C29 1 f1\n").append("C33 1 f1\n").append("C37 1 f1\n").append("C41 1 f1\n")
            .append("C45 1 f1\n").append("C49 1 f1\n").append("\n").append("C2 1 f2\n")
            .append("C6 1 f2\n").append("C10 1 f2\n").append("C14 1 f2\n").append("C18 1 f2\n")
            .append("C22 1 f2\n").append("C26 1 f2\n").append("C30 1 f2\n").append("C34 1 f2\n")
            .append("C38 1 f2\n").append("C42 1 f2\n").append("C46 1 f2\n").append("C50 1 f2\n")
            .append("\n").append("C3 1 f3\n").append("C7 1 f3\n").append("C11 1 f3\n")
            .append("C15 1 f3\n").append("C19 1 f3\n").append("C23 1 f3\n").append("C27 1 f3\n")
            .append("C31 1 f3\n").append("C35 1 f3\n").append("C39 1 f3\n").append("C43 1 f3\n")
            .append("C47 1 f3\n").append("C51 1 f3\n").append("\n").append("C4 1 f4\n")
            .append("C8 1 f4\n").append("C12 1 f4\n").append("C16 1 f4\n").append("C20 1 f4\n")
            .append("C24 1 f4\n").append("C28 1 f4\n").append("C32 1 f4\n").append("C36 1 f4\n")
            .append("C40 1 f4\n").append("C44 1 f4\n").append("C48 1 f4\n").append("C52 1 f4")
            .toString());
    FreecellController controller = new SimpleFreecellController(model, in, out);

    controller.playGame(model.getDeck(), 52, 4, false);

    assertEquals(out.toString(), "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♣\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5: 2♣\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9: 3♣\n"
        + "C10: 3♦\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13: 4♣\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17: 5♣\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21: 6♣\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25: 7♣\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29: 8♣\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33: 9♣\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37: 10♣\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41: J♣\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45: Q♣\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49: K♣\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c5 card number 1 to c10\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♣\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9: 3♣\n"
        + "C10: 3♦, 2♣\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13: 4♣\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17: 5♣\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21: 6♣\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25: 7♣\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29: 8♣\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33: 9♣\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37: 10♣\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41: J♣\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45: Q♣\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49: K♣\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c10 card number 1 to c16\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♣\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9: 3♣\n"
        + "C10:\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13: 4♣\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠, 3♦, 2♣\n"
        + "C17: 5♣\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21: 6♣\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25: 7♣\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29: 8♣\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33: 9♣\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37: 10♣\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41: J♣\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45: Q♣\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49: K♣\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c16 card number 3 to c5\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♣\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5: 2♣\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9: 3♣\n"
        + "C10:\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13: 4♣\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠, 3♦\n"
        + "C17: 5♣\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21: 6♣\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25: 7♣\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29: 8♣\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33: 9♣\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37: 10♣\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41: J♣\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45: Q♣\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49: K♣\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c16 card number 2 to c10\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♣\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5: 2♣\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9: 3♣\n"
        + "C10: 3♦\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13: 4♣\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17: 5♣\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21: 6♣\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25: 7♣\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29: 8♣\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33: 9♣\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37: 10♣\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41: J♣\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45: Q♣\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49: K♣\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "Invalid source pile. Try again.\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c1 card number 1 to f1\n"
        + "F1: A♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5: 2♣\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9: 3♣\n"
        + "C10: 3♦\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13: 4♣\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17: 5♣\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21: 6♣\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25: 7♣\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29: 8♣\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33: 9♣\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37: 10♣\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41: J♣\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45: Q♣\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49: K♣\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c5 card number 1 to f1\n"
        + "F1: A♣, 2♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9: 3♣\n"
        + "C10: 3♦\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13: 4♣\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17: 5♣\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21: 6♣\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25: 7♣\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29: 8♣\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33: 9♣\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37: 10♣\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41: J♣\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45: Q♣\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49: K♣\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c9 card number 1 to f1\n"
        + "F1: A♣, 2♣, 3♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10: 3♦\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13: 4♣\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17: 5♣\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21: 6♣\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25: 7♣\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29: 8♣\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33: 9♣\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37: 10♣\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41: J♣\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45: Q♣\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49: K♣\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c13 card number 1 to f1\n"
        + "F1: A♣, 2♣, 3♣, 4♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10: 3♦\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17: 5♣\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21: 6♣\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25: 7♣\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29: 8♣\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33: 9♣\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37: 10♣\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41: J♣\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45: Q♣\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49: K♣\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c17 card number 1 to f1\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10: 3♦\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21: 6♣\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25: 7♣\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29: 8♣\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33: 9♣\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37: 10♣\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41: J♣\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45: Q♣\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49: K♣\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c21 card number 1 to f1\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10: 3♦\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25: 7♣\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29: 8♣\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33: 9♣\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37: 10♣\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41: J♣\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45: Q♣\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49: K♣\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c25 card number 1 to f1\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10: 3♦\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29: 8♣\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33: 9♣\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37: 10♣\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41: J♣\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45: Q♣\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49: K♣\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c29 card number 1 to f1\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10: 3♦\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33: 9♣\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37: 10♣\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41: J♣\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45: Q♣\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49: K♣\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c33 card number 1 to f1\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10: 3♦\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37: 10♣\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41: J♣\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45: Q♣\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49: K♣\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c37 card number 1 to f1\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10: 3♦\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41: J♣\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45: Q♣\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49: K♣\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c41 card number 1 to f1\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10: 3♦\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45: Q♣\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49: K♣\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c45 card number 1 to f1\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10: 3♦\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49: K♣\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c49 card number 1 to f1\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2: A♦\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10: 3♦\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c2 card number 1 to f2\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6: 2♦\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10: 3♦\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c6 card number 1 to f2\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10: 3♦\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c10 card number 1 to f2\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14: 4♦\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c14 card number 1 to f2\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18: 5♦\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c18 card number 1 to f2\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22: 6♦\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c22 card number 1 to f2\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26: 7♦\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c26 card number 1 to f2\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30: 8♦\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c30 card number 1 to f2\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34: 9♦\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c34 card number 1 to f2\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38: 10♦\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c38 card number 1 to f2\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42: J♦\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c42 card number 1 to f2\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46: Q♦\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c46 card number 1 to f2\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50: K♦\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c50 card number 1 to f2\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3: A♥\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c3 card number 1 to f3\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7: 2♥\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c7 card number 1 to f3\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11: 3♥\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c11 card number 1 to f3\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15: 4♥\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c15 card number 1 to f3\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19: 5♥\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c19 card number 1 to f3\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23: 6♥\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c23 card number 1 to f3\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27: 7♥\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c27 card number 1 to f3\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31: 8♥\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c31 card number 1 to f3\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35: 9♥\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c35 card number 1 to f3\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39: 10♥\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c39 card number 1 to f3\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39:\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43: J♥\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c43 card number 1 to f3\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39:\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43:\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47: Q♥\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c47 card number 1 to f3\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39:\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43:\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47:\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51: K♥\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c51 card number 1 to f3\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4: A♠\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39:\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43:\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47:\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51:\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c4 card number 1 to f4\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F4: A♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4:\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8: 2♠\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39:\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43:\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47:\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51:\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c8 card number 1 to f4\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F4: A♠, 2♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4:\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8:\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12: 3♠\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39:\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43:\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47:\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51:\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c12 card number 1 to f4\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F4: A♠, 2♠, 3♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4:\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8:\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12:\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16: 4♠\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39:\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43:\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47:\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51:\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c16 card number 1 to f4\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F4: A♠, 2♠, 3♠, 4♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4:\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8:\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12:\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16:\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20: 5♠\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39:\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43:\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47:\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51:\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c20 card number 1 to f4\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F4: A♠, 2♠, 3♠, 4♠, 5♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4:\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8:\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12:\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16:\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20:\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24: 6♠\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39:\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43:\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47:\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51:\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c24 card number 1 to f4\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4:\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8:\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12:\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16:\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20:\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24:\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28: 7♠\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39:\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43:\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47:\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51:\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c28 card number 1 to f4\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4:\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8:\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12:\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16:\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20:\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24:\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28:\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32: 8♠\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39:\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43:\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47:\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51:\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c32 card number 1 to f4\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4:\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8:\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12:\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16:\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20:\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24:\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28:\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32:\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36: 9♠\n"
        + "C37:\n"
        + "C38:\n"
        + "C39:\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43:\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47:\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51:\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c36 card number 1 to f4\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4:\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8:\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12:\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16:\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20:\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24:\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28:\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32:\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36:\n"
        + "C37:\n"
        + "C38:\n"
        + "C39:\n"
        + "C40: 10♠\n"
        + "C41:\n"
        + "C42:\n"
        + "C43:\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47:\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51:\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c40 card number 1 to f4\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4:\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8:\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12:\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16:\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20:\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24:\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28:\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32:\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36:\n"
        + "C37:\n"
        + "C38:\n"
        + "C39:\n"
        + "C40:\n"
        + "C41:\n"
        + "C42:\n"
        + "C43:\n"
        + "C44: J♠\n"
        + "C45:\n"
        + "C46:\n"
        + "C47:\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51:\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c44 card number 1 to f4\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4:\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8:\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12:\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16:\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20:\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24:\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28:\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32:\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36:\n"
        + "C37:\n"
        + "C38:\n"
        + "C39:\n"
        + "C40:\n"
        + "C41:\n"
        + "C42:\n"
        + "C43:\n"
        + "C44:\n"
        + "C45:\n"
        + "C46:\n"
        + "C47:\n"
        + "C48: Q♠\n"
        + "C49:\n"
        + "C50:\n"
        + "C51:\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c48 card number 1 to f4\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4:\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8:\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12:\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16:\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20:\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24:\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28:\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32:\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36:\n"
        + "C37:\n"
        + "C38:\n"
        + "C39:\n"
        + "C40:\n"
        + "C41:\n"
        + "C42:\n"
        + "C43:\n"
        + "C44:\n"
        + "C45:\n"
        + "C46:\n"
        + "C47:\n"
        + "C48:\n"
        + "C49:\n"
        + "C50:\n"
        + "C51:\n"
        + "C52: K♠\n"
        + "input card index\n"
        + "input destination pile\n"
        + "Moving c52 card number 1 to f4\n"
        + "F1: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n"
        + "F2: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n"
        + "F3: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n"
        + "F4: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3:\n"
        + "C4:\n"
        + "C5:\n"
        + "C6:\n"
        + "C7:\n"
        + "C8:\n"
        + "C9:\n"
        + "C10:\n"
        + "C11:\n"
        + "C12:\n"
        + "C13:\n"
        + "C14:\n"
        + "C15:\n"
        + "C16:\n"
        + "C17:\n"
        + "C18:\n"
        + "C19:\n"
        + "C20:\n"
        + "C21:\n"
        + "C22:\n"
        + "C23:\n"
        + "C24:\n"
        + "C25:\n"
        + "C26:\n"
        + "C27:\n"
        + "C28:\n"
        + "C29:\n"
        + "C30:\n"
        + "C31:\n"
        + "C32:\n"
        + "C33:\n"
        + "C34:\n"
        + "C35:\n"
        + "C36:\n"
        + "C37:\n"
        + "C38:\n"
        + "C39:\n"
        + "C40:\n"
        + "C41:\n"
        + "C42:\n"
        + "C43:\n"
        + "C44:\n"
        + "C45:\n"
        + "C46:\n"
        + "C47:\n"
        + "C48:\n"
        + "C49:\n"
        + "C50:\n"
        + "C51:\n"
        + "C52:\n"
        + "Game over.\n");
  }
}
