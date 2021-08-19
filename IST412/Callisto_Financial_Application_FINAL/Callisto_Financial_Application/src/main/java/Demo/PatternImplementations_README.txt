USE CASE ONE AND TWO STILL IN PROGRESS - HOWEVER, PATTERNS ARE IMPLEMENTED

DESIGN PATTERN: Singleton
MODEL LOCATION FILE: LoanHistory.java
IMPLEMENTATION LOCATION: MFinanceDriver.java
FIELD DECLARATION: private LoanHistory loanHistory = LoanHistory.getInstance(); (Line 25)
EXAMPLE LOGIC LOCATION: displayEmployeeOptions (loanHistory.add(new LoanRequest())...)

INTERFACE PATTERN: Navigation Tabs
MODEL LOCATION FILE: LoginSelectionUI.java
IMPLEMENTATION LOCATION: LoginSelectionUI.java (CustomerLoginBtnActionPerformed,
EmplLoginBtnActionPerformed, AdminLoginBtnActionPerformed, ShareHolderLoginBtnActionPerformed)
INTERFACE UI: LoginSelectionUI.java (Design)