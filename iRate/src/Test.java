import java.io.*;
import java.sql.*;
import java.util.Properties;


public class Test {
	public static void main(String[] args) {
		Driver.buildTableFromFile();
		
		String protocol = "jdbc:derby:";
        String dbName = "iRate001";
        String connStr = protocol + dbName + ";create=true";
        Properties props = new Properties(); // connection properties
        // providing a user name and password is optional in the embedded
        // and derbyclient frameworks
        props.put("user", "user0703");
        props.put("password", "user0703");
        try (
                Connection conn = DriverManager.getConnection(connStr, props);
        		Statement stmt = conn.createStatement();	
        ) {
        	// --------------------------------------------
        	// Added back deleted test cases:
        	// Because we implemented the user interface,
        	// our program expects user input. In order to automate
        	// the test process, we used System.setIn() to emulate
        	// user inputs. 
        	// --------------------------------------------
        	
        	// freeGift function testing
        	System.out.println("\n**********Test for freeGift function**********\n");
        	System.out.println("****Test for positive input****");
        	String userInput = "2019-06-23";
        	System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        	System.out.println("User input: " + userInput);
            testHelper.freeGift(conn);

            // negative input testing
            System.out.println("\n****Test for negative input****");
            userInput = "2019-06-26";
        	System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        	System.out.println("User input: " + userInput);
            testHelper.freeGift(conn);
            
            
            
            // movieRating function testing
            System.out.println("\n**********Test for movieRating function**********\n");
            System.out.println("****Test for positive input****");
            userInput = "Rush hour";
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            System.out.println("User input: " + userInput);
            testHelper.movieRating(conn);
            
            // negative input testing
            System.out.println("\n****Test for negative input****");
            userInput = "Not included";
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            System.out.println("User input: " + userInput);
            testHelper.movieRating(conn);
            System.out.println("");
            
            
            
            // freeTicket function testing
            System.out.println("\n**********Test for freeTicket function**********\n");
            testHelper.freeTicket(conn);
            
            
            
            // mostReview function testing
            System.out.println("\n**********Test for mostReview function**********\n");
            System.out.println("****Test for positive input****");
            System.out.println("User input: 2019-06-22");
            testHelper.mostReview(conn, "2019-06-22");
            
            // negative input testing
            System.out.println("\n****Test for negative input****");
            System.out.println("User input: 2019-06-24");
            testHelper.mostReview(conn, "2019-06-24");
            
            
            
            
            
            // registerUser function testing
            System.out.println("\n**********Test for Register function**********\n");
            // print customers
            System.out.println("Print customer table");
            printTable.printCustomer(conn);
            
            userInput = "fhong" + System.getProperty("line.separator") + "fh@neu.edu" + System.getProperty("line.separator");
            System.out.println("User input: fhong, fh@neu.edu");
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            testHelper.registerUser(conn);
            
            // negative input testing
            //System.out.println("\n****Test for negative input****");
            //userInput = "Yan" + System.getProperty("line.separator") + "yan.edu" + System.getProperty("line.separator");
            //System.out.println("User input: Yan, yan.edu");
            //System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            //testHelper.registerUser(conn);
            
            // print customers
            System.out.println("Print customer table");
            printTable.printCustomer(conn);
            
            


            
            // logIn function testing
            System.out.println("\n**********Test for logIn function**********\n");
            userInput = "admin" + System.getProperty("line.separator") + "admin@admin.com" + System.getProperty("line.separator");
            System.out.println("User input: admin, admin@admin.com");
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            int CURRENT_USERID = testHelper.login(conn);
            System.out.println("\ncurrent login userId is: " + CURRENT_USERID);
            
            // negative input testing
            //userInput = "yan" + System.getProperty("line.separator") + "yan.edu" + System.getProperty("line.separator");
            //System.out.println("User input: yan, yan.edu");
            //System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            //int CURRENT_USERID = testHelper.login(conn);
            //System.out.println("\ncurrent login userId is: " + CURRENT_USERID);
            
            
            
            
            
            // deleteMovie function testing
            System.out.println("\n**********Test for deleteMovie function**********\n");
            System.out.println("****Test for positive input****");
            
            // print movies table
            System.out.println("print movie table");
            printTable.printMovie(conn);
            
            userInput = "Rush hour";
            System.out.println("User input: "+ userInput);
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            testHelper.deleteMovie(conn);
            
            // print movies table again, Rush hour should have been deleted.
            System.out.println("print movie table");
            printTable.printMovie(conn);
            
            // negative input testing
            System.out.println("****Test for negative input****");
            userInput = "Not included";
            System.out.println("User input: "+ userInput);
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            testHelper.deleteMovie(conn);
            
            
 
            
            
            // addMovie function testing
            System.out.println("\n**********Test for addMovie function**********\n");
            
            // print movies table
            System.out.println("print movie table");
            printTable.printMovie(conn);
            
            userInput = "Rush hour";
            System.out.println("User input: "+ userInput);
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            testHelper.addMovie(conn);

            // print movies again, Rush hour should appear again.
            System.out.println("print movie table");
            printTable.printMovie(conn);
            
            
            
            
            
            
            System.out.println("\n**********Test for buyTicket function**********\n");
            System.out.println("Test for positive input");
            
            // print attendance table
            System.out.println("print attendance table");
            printTable.printAttendance(conn);
            
            userInput = "Rush hour";
            System.out.println("User input: "+ userInput);
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            testHelper.buyTicket(conn);
            
            // print attendance again, Rush Hour should have one more attendance
            System.out.println("print attendance table");
            printTable.printAttendance(conn);
            
            // negative input testing
            System.out.println("Test for negative input");
            userInput = "Not included";
            System.out.println("User input: "+ userInput);
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            testHelper.buyTicket(conn);
            
            
            
            
            
            
            
            System.out.println("\n**********Test for reviewMovie function**********\n");
            
            // print review table
            System.out.println("print review table");
            printTable.printReview(conn);
            
            userInput = "Rush hour"  + System.getProperty("line.separator") + "3" + System.getProperty("line.separator") + "fantastic";
            System.out.println("User input: Rush hour, 3, fantastic");
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            testHelper.reviewMovie(conn);          
            
            // print review again, should have one more review for Rush Hour
            System.out.println("print review table");
            printTable.printReview(conn);
            
            // negative input testing
            //userInput = "not included"  + System.getProperty("line.separator") + "0" + System.getProperty("line.separator") + "fantastic";
            //System.out.println("User input: not included, 0, fantastic");
            //System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            //Helper.reviewMovie(conn);    
            
            
            
            
            
            
            
            
            
            
            System.out.println("\n**********Test for voteReview function**********\n");
            
            // print endorsement table
            System.out.println("print endorsement table");
            printTable.printEndorsement(conn);
            
            userInput = "Hotel Transylvania 3: Summer Vacation"  + System.getProperty("line.separator") + "9009";
            System.out.println("User input: Hotel Transylvania 3: Summer Vacation, 9009");
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            testHelper.voteReview(conn);     
            
            // print endorsement again, should have one more endorsement for the review added above
            System.out.println("print endorsement table");
            printTable.printEndorsement(conn);
            
            
            
            
            
            
           
            
            
            
            
            
            
            // -------------------------
            // Tests for triggers and procedures:
            // we test all the restrictions (checks, uniques...) in tables and all the triggers we created.
            // -------------------------
            
			// 1. Test invalid emails
            System.out.println("************************* Triggers and procedures testing****************************");
            System.out.println("************************* 1. Test Invalid Emails****************************");
			try {
				System.out.println("Test 1: Create customer email without string before \"@\"");
				String invalid_email = "INSERT INTO Customer(customer_Name, email, join_date) VALUES"
						+ "('fhong', '@gmail.com', '2019-06-20 12:00:00')";
				stmt.executeUpdate(invalid_email);
			} catch (SQLException e) {
				System.out.println("Test1 result: " + e.getMessage() + "\n");
			}

			try {
				System.out.println("Test 2: Create customer email without \".\"");
				String invalid_email = "INSERT INTO Customer(customer_Name, email, join_date) VALUES"
						+ "('fhong', 'fhong@gmailcom', '2019-06-20 12:00:00')";
				stmt.executeUpdate(invalid_email);
			} catch (SQLException e) {
				System.out.println("Test2 result: " + e.getMessage() + "\n");
			}

			try {
				System.out.println("Test 3: Create customer email without \"@\"");
				String invalid_email = "INSERT INTO Customer(customer_Name, email, join_date) VALUES"
						+ "('fhong', 'fhonggmail.com', '2019-06-20 12:00:00')";
				stmt.executeUpdate(invalid_email);
			} catch (SQLException e) {
				System.out.println("Test3 result: " + e.getMessage() + "\n");
			}
			
			// 2. Test review limit:
			// - unique (movie_id, customer_id)
			// - createTrigger_review_limit_by_attendance
			// - createTrigger_review_limit_by_date
			// - createTrigger_review_limit_by_date2
			
			System.out.println("************************* Test Review Limit****************************");
			try {
				System.out.println("Test 4: Review the same movie twice");
				// we know that customer 9001 already has reviewed movie 7002, so this should fail.
				String review_twice =
			              "INSERT INTO Review(customer_id, movie_id, review_date, rating, review) VALUES" +
			                      "(9001, 7002, '2019-06-20 12:00:00', 3, 'second review should fail')";
			     stmt.executeUpdate(review_twice);
			} catch (SQLException e) {
				System.out.println("Test4 result: " + e.getMessage() + "\n");
			}
			
			printTable.printAttendance(conn);
			
			try {
				System.out.println("Test 5: Review without watching");
			
				String review_no_watch =
			              "INSERT INTO Review(customer_id, movie_id, review_date, rating, review) VALUES" +
			                      "(7009, 8008, '2019-06-20 12:00:00', 3, 'review without watching should fail')";
			    stmt.executeUpdate(review_no_watch);
			} finally {
				// we know that customer 7009 has never watched movie 8008.
				// So his/her review will be silently deleted and not displayed.
				printTable.printReview(conn);
			}
			
			try {
				System.out.println("Test 6: Review before watch");
			
				String review_before_watch =
			              "INSERT INTO Review(customer_id, movie_id, review_date, rating, review) VALUES" +
			                      "(7012, 8000, '2019-06-20 12:00:00', 3, 'review before watch should fail')";
			    stmt.executeUpdate(review_before_watch);
			} finally {
				// we know that customer 7012 watched movie 8000 on 2019-06-21 23:03:20.0.
				// So his/her review will be silently deleted and not displayed.
				printTable.printReview(conn);
			}
			
			try {
				System.out.println("Test 7: Review 7 days after watch");
			
				String review_7days_after_watch =
			              "INSERT INTO Review(customer_id, movie_id, review_date, rating, review) VALUES" +
			                      "(7012, 8000, '2019-07-20 12:00:00', 3, 'review 7 days after watch should fail')";
			    stmt.executeUpdate(review_7days_after_watch);
			} finally {
				// we know that customer 7012 watched movie 8000 on 2019-06-21 23:03:20.0.
				// So his/her review will be silently deleted and not displayed.
				printTable.printReview(conn);
			}
			
			
			System.out.println("************************* Test Endorsement Limit ****************************");
			// 3. Test endorsement limit:
			// - no endorsement of someone's own review
			// - no endorsement before review
			// - no endorsement 3 days after review
			try {
				System.out.println("Test 8: No endorsement of someone\'s own review");
			
				String endorse_own_review =
			              "INSERT INTO Endorsement(review_id, endorser_id, endorse_date) VALUES" +
			                      "(9008, 7009, '2019-06-20 12:00:00')";
			    stmt.executeUpdate(endorse_own_review);
			} finally {
				// we know that customer 7009 has reviewed a movie with review_id 9008.
				// So his/her should not be able to endorse his/her own review.
				printTable.printEndorsement(conn);
			}
			
			try {
				System.out.println("Test 9: No Endorsement before review");
			
				String endorse_before_review =
			              "INSERT INTO Endorsement(review_id, endorser_id, endorse_date) VALUES" +
			                      "(9008, 7008, '2018-06-20 12:00:00')";
			    stmt.executeUpdate(endorse_before_review);
			} finally {
				// we know that review 9008 was created on 2019-06-24 23:03:20.0
				// So it is impossible to endorse it on a date before that
				printTable.printEndorsement(conn);
			}
			
			try {
				System.out.println("Test 10: no endorsement 3 days after review");
			
				String endorse_after_3day =
			              "INSERT INTO Endorsement(review_id, endorser_id, endorse_date) VALUES" +
			                      "(9008, 7008, '2020-06-28 12:00:00')";
			    stmt.executeUpdate(endorse_after_3day);
			} finally {
				// we know that review 9008 was created on 2019-06-24 23:03:20.0
				// So it is impossible to endorse it on a date before that
				printTable.printEndorsement(conn);
			}
			
			
			
			
			
			
			
			
			 // Tests for deleting data and corresponding action

            try {
//            	conn.setAutoCommit(false);
//                System.out.println("Committing deletions.");
//    			Savepoint sp1 = conn.setSavepoint("Delete");
//    			
    			
                // delete customer  -- xun
                System.out.println("Test : If a customer is deleted, all of his or her attendances, reviews and endorsements should be deleted.\n");
                System.out.println("Deleting customer 'xun' from Cutomer");
                stmt.execute("DELETE FROM Customer WHERE customer_Name = 'xun'");
                System.out.println("print customer table");
                printTable.printCustomer(conn);
                System.out.println("print attendance table");
                printTable.printAttendance(conn);
                System.out.println("print review table");
                printTable.printReview(conn);
                System.out.println("print endorsement table");
                printTable.printEndorsement(conn);
                System.out.println();

                // delete movie -- The Lion King
                System.out.println("Test : If a movie is deleted, all of its attendances, reviews and endorsements should be deleted.\n");
                System.out.println("Deleting movie 'The Lion King' from Movie");
                stmt.execute("DELETE FROM Movie WHERE movie_title = 'The Lion King'");
                System.out.println("print movie table");
                printTable.printMovie(conn);
                System.out.println("print attendance table");
                printTable.printAttendance(conn);
                System.out.println("print review table");
                printTable.printReview(conn);
                System.out.println("print endorsement table");
                printTable.printEndorsement(conn);
                System.out.println();

                // delete review
                System.out.println("Test : If a review is deleted, all of its endorsements should be deleted.\n");
                System.out.println("Deleting review 'not bad!' from Review...");
                stmt.execute("DELETE FROM Review WHERE review = 'not bad!'");
                System.out.println("print review table");
                printTable.printReview(conn);
                System.out.println("print endorsement table");
                printTable.printEndorsement(conn);
                
                
//                System.out.println("Rolling back deletions.");
//    			conn.rollback(sp1);
//    			conn.setAutoCommit(true);
    			
              } catch (SQLException e) {
                e.printStackTrace();
              }
			
			
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
};