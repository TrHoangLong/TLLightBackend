/****** Object:  StoredProcedure [dbo].[CustOrdersGetForCust]    Script Date: 6/22/2023 7:34:34 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustOrdersGetForCust]
GO

/****** Object:  StoredProcedure [dbo].[CustOrdersGetForCust]    Script Date: 6/22/2023 7:34:34 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO




CREATE PROCEDURE [dbo].[CustOrdersGetForCust]
	@UserId VARCHAR(30)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    SELECT co.*, p.ProductName, p.ProductImage, cu.CustName, cu.Address, cu.MobileNo
	FROM CustOrders co 
	INNER JOIN Product p ON co.ProductId = p.ProductId
	INNER JOIN CustomerUser cu ON co.CustUserId = cu.CustUserId
	WHERE co.CustUserId = @UserId

END
GO


