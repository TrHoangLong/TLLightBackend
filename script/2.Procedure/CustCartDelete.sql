/****** Object:  StoredProcedure [dbo].[CustCartDelete]    Script Date: 6/22/2023 7:25:26 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustCartDelete]
GO

/****** Object:  StoredProcedure [dbo].[CustCartDelete]    Script Date: 6/22/2023 7:25:26 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO




CREATE PROCEDURE [dbo].[CustCartDelete]
	@UserId VARCHAR(30),
	@CustCartId INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	DELETE FROM CustCart WHERE CustCartId = @CustCartId

END
GO


