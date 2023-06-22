/****** Object:  StoredProcedure [dbo].[CustCartGet]    Script Date: 6/22/2023 7:27:28 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustCartGet]
GO

/****** Object:  StoredProcedure [dbo].[CustCartGet]    Script Date: 6/22/2023 7:27:28 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[CustCartGet]
	@UserId VARCHAR(30),
	@CustUserId VARCHAR(30),
	@Status INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	SELECT cc.*, p.ProductName, (cc.ProductPrice * cc.Quantity) AS TotalCart FROM CustCart cc
	LEFT JOIN Product p ON p.ProductId = cc.ProductId
	WHERE (cc. CustUserId = @CustUserId OR @CustUserId = '')
	AND (cc.Status = @Status OR @Status = 0)

END
GO
