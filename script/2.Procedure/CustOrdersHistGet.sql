/****** Object:  StoredProcedure [dbo].[CustOrdersHistGet]    Script Date: 5/9/2023 8:48:19 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustOrdersHistGet]
GO

/****** Object:  StoredProcedure [dbo].[CustOrdersHistGet]    Script Date: 5/9/2023 8:48:19 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[CustOrdersHistGet]
	@UserId VARCHAR(30),
	@CustOrderDate SMALLDATETIME,
	@ProductId VARCHAR(30),
	@CustUserId VARCHAR(30),
	@OrderStatus INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    SELECT co.*, p.ProductName FROM CustOrdersHist co
	LEFT JOIN Product p ON p.ProductId = co.ProductId
	WHERE (co.ProductId = @ProductId OR @ProductId = '')
	AND (co.CustUserId = @CustUserId OR @CustUserId = '')
	AND (co.OrderStatus = @OrderStatus OR @OrderStatus = 0)
	AND (CustOrderDate = @CustOrderDate OR @CustOrderDate IS NULL)

END
GO


