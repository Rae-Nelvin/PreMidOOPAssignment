package premidassg;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

	private String minyakName;

	public Main() {
		// TODO Auto-generated constructor stub

		Scanner sc = new Scanner(System.in);
		ArrayList<Transaction> transaction = new ArrayList<Transaction>();
		ArrayList<Minyak> minyak = new ArrayList<Minyak>();
		int inp = -1;
		boolean isRun = true;

		do {
			
			do {
				
				showMenu();
				try {
					inp = sc.nextInt();
				} catch (Exception e) {
					//TODO: handle exception
					inp = -1;
				}

				switch (inp) {
					case 1:
						newMinyak(minyak);
						System.out.println("Press Enter to continue...");
						sc.nextLine();
						break;
					case 2:
						if(minyak.size() == 0) {
							System.out.println("Tidak ada data minyak");
						}else {
							transaction.add(newTransaction(minyak));
						}
						System.out.println("Press Enter to continue...");
						sc.nextLine();
						break;
					case 3:
						if(minyak.size() == 0) {
							System.out.println("Tidak ada data minyak");
						}else {
							showMinyak(minyak);
						}
						System.out.println("Press Enter to continue...");
						sc.nextLine();
						break;
					case 4:
						if(minyak.size() == 0) {
							System.out.println("Tidak ada data transaksi");
						}else {
							showTransaction(transaction);
						}
						System.out.println("Press Enter to continue...");
						sc.nextLine();
						break;
					case 5:
						if(minyak.size() == 0) {
							System.out.println("Tidak ada data minyak");
						}else {
							deleteMinyak(minyak);
						}
						System.out.println("Press Enter to continue...");
						sc.nextLine();
						break;
					case 6:
						if(minyak.size() == 0) {
							System.out.println("Tidak ada data transaksi");
						}else {
							deleteTransaction(transaction);
						}
						System.out.println("Press Enter to continue...");
						sc.nextLine();
						break;
					case 7:
						isRun = !isRun;
					default:
						
				}

			} while (inp < 1 && inp > 7);

		} while (isRun);

	}

	private void showMenu() {

		System.out.println("===============");
		System.out.println("Selamat datang di");
		System.out.println("Toko Minyak Jaya");
		System.out.println("1. Tambah Minyak");
		System.out.println("2. Tambah Transaksi");
		System.out.println("3. View Minyak");
		System.out.println("4. View Transaksi");
		System.out.println("5. Delete Minyak");
		System.out.println("6. Delete Transaksi");
		System.out.println("7. Exit");
		System.out.println("===============");
		System.out.print("Choice >> ");

	}

	public void newMinyak(ArrayList<Minyak> minyak) {

		Scanner sc = new Scanner(System.in);
		String ID = "";
		String name = "";
		String brand = "";
		int quantity = 0;
		int price = 0;
		double rand1; double rand2; double rand3;
		boolean check = false;
		int index = 0;
		int stokMinyak = 0;

		rand1 = Math.random() * (9 - 0) + 0;
		rand2 = Math.random() * (9 - 0) + 0;
		rand3 = Math.random() * (9 - 0) + 0;
		ID = ("MM") + (int)rand1 + (int)rand2 + (int)rand3;

		System.out.print("Masukkan nama minyak: ");
		name = sc.next();

		if (!minyak.isEmpty()) {

			for (Minyak minyak2 : minyak) {
			
				if(name.equals(minyak2.getName()) == true) {
	
					check = true;
					break;
	
				}
	
				index++;
	
			}

		}

		if (check == true) {
			
			do {
				
				System.out.print("Masukkan jumlah minyak: ");
				try {
					quantity = sc.nextInt();
				} catch (Exception e) {
					//TODO: handle exception
					System.out.println("Jumlah minyak harus diatas 0!");
					quantity = -1;
				}
				sc.nextLine();

			} while (quantity < 1);

			stokMinyak = (int)minyak.get(index).getQuantity() + quantity;
			minyak.get(index).setQuantity(stokMinyak);

		} else {

			System.out.print("Masukkan brand minyak: ");
			brand = sc.next();
			
			do {
				
				System.out.print("Masukkan jumlah minyak: ");
				try {
					quantity = sc.nextInt();
				} catch (Exception e) {
					//TODO: handle exception
					System.out.println("Jumlah minyak harus diatas 0!");
					quantity = -1;
				}
				sc.nextLine();

			} while (quantity < 1);

			do {
				
				System.out.print("Masukkan harga minyak: ");
				try {
					price = sc.nextInt();
				} catch (Exception e) {
					//TODO: handle exception
					System.out.println("Harga harus diatas 0!");
					price = -1;
				}
				sc.nextLine();

			} while (price < 1);

			Minyak newData = new Minyak(ID, name, brand, quantity, price);
			minyak.add(newData);

		}
		
	}

	public void showMinyak(ArrayList<Minyak> minyak) {
		
		System.out.println("===============");
		System.out.println("| ID Minyak | Nama Minyak | Brand Minyak | Quantity | Price |");
		for (Minyak minyak2 : minyak) {
			System.out.printf("| %s | %s | %s | %d | Rp %d |\n",minyak2.getID(), minyak2.getName(), minyak2.getBrand(), minyak2.getQuantity(), minyak2.getPrice());
		}
		System.out.println("===============");

	}

	public Transaction newTransaction(ArrayList<Minyak> minyak) {

		Scanner sc = new Scanner(System.in);
		String ID = "";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
		LocalDate localDate = LocalDate.now();
		String date = dtf.format(localDate);
		String consumentName = "";
		String tellerName = "";
		int totalHarga = 0;
		minyakName = "";
		int quantity = 0;
		int price = 0;
		double rand1; double rand2; double rand3;
		TransactionDetail transactionDetail[] = new TransactionDetail[100];
		int inp = 1;
		int i = 0;
		int stokMinyak = 0;

		rand1 = Math.random() * (9 - 0) + 0;
		rand2 = Math.random() * (9 - 0) + 0;
		rand3 = Math.random() * (9 - 0) + 0;
		ID = "TM" + (int)rand1 + (int)rand2 + (int)rand3;

		System.out.println("List minyak");
		showMinyak(minyak);

		System.out.print("Masukkan nama konsumen : ");
		consumentName = sc.nextLine();
		System.out.print("Masukkan nama teller : ");
		tellerName = sc.nextLine();

		do {

			switch (inp) {
				case 1:
					
					price = 0;
					int index = 0;
					boolean check = false;
					do {

						index = 0;
						System.out.print("Masukkan nama minyak : ");
						minyakName = sc.next();
						
						for (Minyak minyak2 : minyak) {
							
							if (minyak2.getName().equals(minyakName)) {
								check = true;
							}
							else {
								index++;
							}

						}
			
					} while (check == false);

					do {
						
						System.out.print("Masukkan quantity minyak yang dibeli : ");
						try {
							quantity = sc.nextInt();
						} catch (Exception e) {
							//TODO: handle exception
							quantity = -1;
						}
						sc.nextLine();

					} while (quantity < 0 && quantity > minyak.get(index).getQuantity());

					price = (int)minyak.get(index).getPrice() * quantity;
					stokMinyak = (int)minyak.get(index).getQuantity() - quantity;
					minyak.get(index).setQuantity(stokMinyak);
					totalHarga = totalHarga + price;

					transactionDetail[i] = new TransactionDetail(minyakName, quantity, price);
					System.out.print("Masukkan angka 1 jika ingin lanjut, 0 jika ingin keluar: ");

					try {
						inp = sc.nextInt();
					} catch (Exception e) {
						//TODO: handle exception
						inp = 1;
					}

					i++;
					break;
				
				case 0:
					inp = 0;
					break;

				default:
					break;
			}

		} while (inp == 1);

		return new Transaction(ID, consumentName, tellerName, totalHarga, transactionDetail, date, i);
	}

	private void showTransaction(ArrayList<Transaction> transaction) {

		System.out.println("===============");
		System.out.println("| ID Transaksi | Nama Konsumen | Nama Teller | Transaksi Detail | Total Harga | Date |");

		for (Transaction transaction2 : transaction) {

			System.out.printf("| %s | %s | %s |", transaction2.getID(), transaction2.getConsumentName(), transaction2.getTellerName());

			int i = 0;
			for (TransactionDetail transactionDetail : transaction2.getTransactionDetail()) {
				
				if(i == transaction2.getTransactionDetailSize()) {
					break;
				}else {
					System.out.printf(" %s & ", transactionDetail.getMinyakName());
				}
				i++;

			}

			System.out.printf(" Rp %d | %s \n", transaction2.getTotalHarga(), transaction2.getDate());

		}

	}

	private void deleteMinyak(ArrayList<Minyak> minyak) {

		Scanner sc = new Scanner(System.in);
		String ID;
		int index = 0;

		showMinyak(minyak);
		System.out.print("Masukkan ID Minyak yang ingin dihapus: ");
		ID = sc.next();

		for (Minyak minyak2: minyak) {
			
			if(ID.equals(minyak2.getID())) {

				minyak.remove(index);
				break;

			}

			index++;
		}

	}

	private void deleteTransaction(ArrayList<Transaction> transaction) {

		Scanner sc = new Scanner(System.in);
		String ID;
		int index = 0;

		showTransaction(transaction);
		System.out.print("Masukkan ID Transaksi yang ingin dihapus: ");
		ID = sc.nextLine();

		for (Transaction transaction2 : transaction) {
			
			if(ID.equals(transaction2.getID())) {

				transaction.remove(index);
				break;

			}

			index++;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
