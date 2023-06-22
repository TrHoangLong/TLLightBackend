/****** Object:  StoredProcedure [dbo].[CustOrdersUpdateStatus]    Script Date: 6/22/2023 7:35:11 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustOrdersUpdateStatus]
GO

/****** Object:  StoredProcedure [dbo].[CustOrdersUpdateStatus]    Script Date: 6/22/2023 7:35:11 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[CustOrdersUpdateStatus]
	@UserId VARCHAR(30),
	@CustOrderDate SMALLDATETIME,
	@CustOrderId INT,
	@OrderStatus INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    IF @OrderStatus = 9
	BEGIN
		RAISERROR (N'Hủy đơn hàng không xử lý ở đây', 15, 1);
		RETURN;
	END

	UPDATE CustOrders
	SET 
		OrderStatus = @OrderStatus,
		UpdatedUserId = @UserId,
		UpdatedTime = GETDATE()
	WHERE CustOrderDate = @CustOrderDate AND CustOrderId = @CustOrderId

END
GO

