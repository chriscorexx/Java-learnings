COMPUTER LAB BOOKING SYSTEM - COMPLETE BASIC VERSION

Technology:
- Java AWT
- JDBC
- SQLite
- VS Code / Windows

FEATURES

ADMIN
1. Login using admin account.
2. Add computers with computer name and lab name.
3. View registered computers and their status.
4. Create student accounts.
5. View all booking requests.
6. Approve or reject pending booking requests.

STUDENT
1. Login using an account created by Admin.
2. View available computers.
3. Request a computer booking.
4. View own booking requests and status.

BOOKING RULE
When a student requests a computer, it is marked BOOKED and the request status becomes PENDING.
When Admin approves, it remains BOOKED.
When Admin rejects, it becomes AVAILABLE again.

DATABASE
The application automatically creates/uses:
- users
- computers
- bookings

IMPORTANT: Existing computer_lab_booking.db is kept. Do not delete it if you want to retain your current admin account, student accounts, computers and bookings.

ADMIN LOGIN
Username: admin
Password: admin123

If you have already changed or created accounts in your existing database, continue using those accounts.

HOW TO RUN
1. Extract the project folder.
2. Open the folder in VS Code.
3. Open Terminal > New Terminal.
4. Run download-driver.bat once if lib\sqlite-jdbc.jar is not present.
5. Run run.bat.

PowerShell commands:
  .\download-driver.bat
  .\run.bat

SECURITY NOTE
This is an educational starter project. Passwords are stored as plain text for simplicity. Do not use real or reused passwords. Password hashing should be added before real-world use.

Oracle XE is not used or modified.
