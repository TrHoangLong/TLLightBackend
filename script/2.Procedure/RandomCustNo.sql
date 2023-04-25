/****** Object:  UserDefinedFunction [dbo].[RandomCustNo]    Script Date: 4/23/2023 9:42:43 PM ******/
DROP FUNCTION IF EXISTS [dbo].[RandomCustNo]
GO

/****** Object:  UserDefinedFunction [dbo].[RandomCustNo]    Script Date: 4/23/2023 9:42:43 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date, ,>
-- Description:	<Description, ,>
-- =============================================
CREATE FUNCTION [dbo].[RandomCustNo]
()
RETURNS VARCHAR(6)
AS
BEGIN
	-- Declare the return variable here
	DECLARE @NumberRandom VARCHAR(6);
	DECLARE @COUNT INT = 0;

	SELECT @NumberRandom = CAST(FLOOR(rndResult * 999999) AS VARCHAR(6)) FROM rndView

	WHILE LEN(@NumberRandom) < 6
	BEGIN
		SET @NumberRandom = CONCAT('0', @NumberRandom);
	END

	RETURN @NumberRandom;
END
GO


