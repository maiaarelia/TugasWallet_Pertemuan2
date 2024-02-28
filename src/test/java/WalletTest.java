import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {


    @Test
    void WithdrawMoreThanCash() {
        Wallet wallet = new Wallet("Maia Arelia", 70000.0);
        wallet.withdraw(80000.0);
        Assertions.assertEquals(70000.0, wallet.cash);
        Assertions.assertTrue(wallet.cash == 70000.0);
    }

    @Test
    void WithdrawExactAmount() {
        Wallet wallet = new Wallet("Maia Arelia", 10000.0);
        wallet.withdraw(7000.0);
        Assertions.assertEquals(3000.0, wallet.cash);
    }


    @Test
    void WithdrawMinusAmount() {
        Wallet wallet = new Wallet("Maia Arelia", 10000.0);
        wallet.withdraw(-7000.0);
        Assertions.assertTrue(wallet.cash == 10000.0);
    }

    @Test
    void DepositValidMoney (){
        Wallet wallet2 = new Wallet("Maia Arelia", 100000.0);
        wallet2.deposit(90000.0);
        Assertions.assertEquals(190000.0, wallet2.cash);
        Assertions.assertTrue(wallet2.cash == 190000.0);
    }

    @Test
    void DepositZeroAmount() {
        Wallet wallet = new Wallet("Maia Arelia", 100000.0);
        Double depositNow = wallet.deposit(0.0);
        Assertions.assertEquals(100000.0, wallet.cash);
    }

    @Test
    void DepositMinusAmount() {
        Wallet wallet = new Wallet("Maia Arelia", 100000.0);
        wallet.deposit(-1000.0);
        Assertions.assertEquals(100000.0, wallet.cash);
    }

    @Test
    void testAddCard(){
        Wallet wallet = new Wallet("Arelia Maia", new ArrayList<>(), 100000.0);
        wallet.addCard("BCA", 198752);
        assertEquals(1, wallet.getCards().size());
    }


    @Test
    void testRemoveCard(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("Maia", "123456", "Bank A", LocalDate.now()));
        cards.add(new Card("Maia", "789012", "Bank B", LocalDate.now()));
        cards.add(new Card("Maia", "345678", "Bank C", LocalDate.now()));
        Wallet wallet = new Wallet("Maia", cards, 10000.0);

        wallet.removeCard(123456);
        assertEquals(2, wallet.getCards().size());
    }

}
