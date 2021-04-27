This microservice used to print a cash receipt in "pdf" or "txt" format.

Options "cash-receipt.type" define printing file format.

The "/cashReceipt " controller gets "OrderDto", wish contains:

- "OrderCostDto"
- list of "PurchaseFullResponseDto"
- username
- discount for the user on the discount card

Then cash receipt is printed in the selected format.

After printing, controller returns a reference to the printed file.


