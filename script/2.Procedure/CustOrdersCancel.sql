/****** Object:  StoredProcedure [dbo].[CustOrdersCancel]    Script Date: 6/22/2023 7:33:42 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustOrdersCancel]
GO

/****** Object:  StoredProcedure [dbo].[CustOrdersCancel]    Script Date: 6/22/2023 7:33:42 PM ******/
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

	IF EXISTS (SELECT 1 FROM CustOrders WHERE CustOrderDate = @CustOrderDate AND CustOrderId = @CustOrderId AND OrderStatus = 9)
	BEGIN
		RAISERROR (N'Đơn hàng này đã hủy', 15, 1);
		RETURN;
	END

	IF EXISTS (SELECT 1 FROM CustOrders WHERE CustOrderDate = @CustOrderDate AND CustOrderId = @CustOrderId AND OrderStatus = 8)
	BEGIN
		RAISERROR (N'Đơn hàng này đã yêu cầu hủy', 15, 1);
		RETURN;
	END

	UPDATE CustOrders
	SET 
		OrderStatus = 8,
		UpdatedUserId = @UserId,
		UpdatedTime = GETDATE()
	WHERE CustOrderDate = @CustOrderDate AND CustOrderId = @CustOrderId;

END
GO

