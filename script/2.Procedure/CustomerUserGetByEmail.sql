/****** Object:  StoredProcedure [dbo].[CustomerUserGetByEmail]    Script Date: 6/22/2023 7:29:50 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[CustomerUserGetByEmail]
GO

/****** Object:  StoredProcedure [dbo].[CustomerUserGetByEmail]    Script Date: 6/22/2023 7:29:50 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO





CREATE PROCEDURE [dbo].[CustomerUserGetByEmail] 
	@Email VARCHAR(200)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    SELECT * FROM CustomerUser WHERE Email = @Email AND [Status] = 1
END
GO


