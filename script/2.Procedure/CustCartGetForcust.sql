/****** Object:  StoredProcedure [dbo].[CustCartGetForcust]    Script Date: 6/22/2023 7:27:47 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustCartGetForcust]
GO

/****** Object:  StoredProcedure [dbo].[CustCartGetForcust]    Script Date: 6/22/2023 7:27:47 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO





CREATE PROCEDURE [dbo].[CustCartGetForcust]
	@UserId VARCHAR(30)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	SELECT cc.*, p.ProductName, p.ProductImage, (cc.Quantity * cc.ProductPrice) AS TotalCart FROM CustCart cc
	INNER JOIN Product p ON cc.ProductId = p.ProductId
	WHERE cc.CustUserId = @UserId

END
GO


