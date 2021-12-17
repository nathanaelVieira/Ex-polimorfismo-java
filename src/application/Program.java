package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.ImportedProduct;
import model.Product;
import model.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<Product>();
		
		System.out.print("Enter the number of product: ");
		int n = sc.nextInt();
		
		for ( int i=1; i<=n; i++) {
			
			System.out.println("Product #" + i + "data:");
			System.out.print("Common, used or imported?  (c/u/i) ");
			char prd = sc.next().charAt(0);
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine().trim();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if ( prd == 'i') {

				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			} else if ( prd == 'c') {

				list.add(new Product(name, price));
			} else if ( prd == 'u') {

				System.out.print("Manufacture date: ");
				Date manufactureDate = sdf.parse(sc.next());
				list.add( new UsedProduct(name, price, manufactureDate));
			}
		}
		System.out.println("---------------------------------------");
		
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		
		
		
		sc.close();
	}

}
