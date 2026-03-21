<%-- 
    Document   : account
    Created on : Mar 6, 2026, 9:39:21?AM
    Author     : hp
--%>

<%@page import="bean.AccountBean" %>
<jsp:useBean id="acc" class="bean.AccountBean" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank Account</title>
    </head>
    <body>
        <h1>Bank Account Operations</h1>
        <form method="post">
            Account No: <input type="text" name="ano"><br><br>
            Name: <input type="text" name="name"><br><br>
            Amount: <input type="text" name="amount"><br><br>
            <input type="submit" name="action" value="Deposit">
            <input type="submit" name="action" value="Withdraw">
        </form>
        
        <% 
            String action = request.getParameter("action");
            if(action!=null){
                int ano= Integer.parseInt(request.getParameter("ano"));
                String name = request.getParameter("name");
                double amount= Double.parseDouble(request.getParameter("amount"));
                acc.setAccountNo(ano);
                acc.setName(name);
                if(action.equals("Deposit")){
                    acc.deposit(amount);
                }else if(action.equals("Withdraw")){
                    boolean success=acc.withdraw(amount);
                    if(!success){
                        out.println("<p style='color:red'>Insufficient Balance</p>");
                    }
                }
            }
        %>
        <h3>Account Information</h3>
        Account No:<%=acc.getAccountNo() %><br>
        Name:<%=acc.getName() %><br>
        Balance:<%=acc.getBalance() %><br>
    </body>
</html>
