/****** Object:  StoredProcedure [dbo].[CustOrdersCancelConfirm]    Script Date: 5/8/2023 10:42:20 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustOrdersCancelConfirm]
GO

/****** Object:  StoredProcedure [dbo].[CustOrdersCancelConfirm]    Script Date: 5/8/2023 10:42:20 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[CustOrdersCancelConfirm]
	@UserId VARCHAR(30),
	@CustOrderDate SMALLDATETIME,
	@CustOrderId INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	DECLARE @OrderStatus INT = 0 ;
	SELECT @OrderStatus FROM CustOrders WHERE CustOrderDate = @CustOrderDate AND CustOrderId = @CustOrderId

	IF @OrderStatus <> 8 
	BEGIN
		RAISERROR (N'Đơn hàng chưa đươc yêu cầu hủy', 15, 1);
		RETURN;
	END

	UPDATE CustOrders
	SET 
		OrderStatus = 9,
		UpdatedUserId = @UserId,
		UpdatedTime = GETDATE()
	WHERE CustOrderDate = @CustOrderDate AND CustOrderId = @CustOrderId

END
GO


