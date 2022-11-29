import rzp.oop.transaction.TransactionControllerExtra;
import java.util.List;

public class TransactionControllerClassExtra implements TransactionControllerExtra {
    public boolean accept(Transaction transaction, Customer customer) {
        boolean success = true;
        customer.saveState();

        for (Product product : transaction.products)
            success &= (product.price > 0) && customer.buy(product);

        success &= (customer.getTime() < transaction.expireTo);
        if (success) return true;
        customer.restoreState();
        return false;
    }

    public long predictMaxCustomerTime(Customer customer, List<Product> products) {
        return customer.getTime() + 99L * products.size();
    }

    public boolean accept(List<Transaction> transactions, Customer customer) {
        boolean success = false;
        for (Transaction transaction : transactions)
            success |= accept(transaction, customer);
        return success;
    }
}