/****** Object:  StoredProcedure [dbo].[CustomerUserGetById]    Script Date: 6/22/2023 7:30:33 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustomerUserGetById]
GO

/****** Object:  StoredProcedure [dbo].[CustomerUserGetById]    Script Date: 6/22/2023 7:30:33 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO




CREATE PROCEDURE [dbo].[CustomerUserGetById] 
	@UserId VARCHAR(30)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    SELECT * FROM CustomerUser WHERE CustUserId = @UserId AND Status = 1
END
GO


