/****** Object:  StoredProcedure [dbo].[TokenGet]    Script Date: 6/22/2023 7:45:27 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[TokenGet]
GO

/****** Object:  StoredProcedure [dbo].[TokenGet]    Script Date: 6/22/2023 7:45:27 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO




CREATE PROCEDURE [dbo].[TokenGet]
	@Token VARCHAR(500)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT * FROM Token WHERE Token LIKE @Token 
END
GO


