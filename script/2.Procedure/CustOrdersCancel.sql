/****** Object:  StoredProcedure [dbo].[CustOrdersCancel]    Script Date: 5/8/2023 10:42:20 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustOrdersCancel]
GO

/****** Object:  StoredProcedure [dbo].[CustOrdersCancel]    Script Date: 5/8/2023 10:42:20 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[CustOrdersCancel]
	@UserId VARCHAR(30),
	@CustOrderDate SMALLDATETIME,
	@CustOrderId INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	UPDATE CustOrders
	SET 
		OrderStatus = 8,
		UpdatedUserId = @UserId,
		UpdatedTime = GETDATE()
	WHERE CustOrderDate = @CustOrderDate AND CustOrderId = @CustOrderId;

END
GO


