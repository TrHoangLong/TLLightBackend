/****** Object:  UserDefinedFunction [dbo].[GetBusinessDate]    Script Date: 6/22/2023 7:19:46 PM ******/
DROP FUNCTION IF EXISTS [dbo].[GetBusinessDate]
GO

/****** Object:  UserDefinedFunction [dbo].[GetBusinessDate]    Script Date: 6/22/2023 7:19:46 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date, ,>
-- Description:	<Description, ,>
-- =============================================
CREATE FUNCTION  [dbo].[GetBusinessDate]
()
RETURNS SMALLDATETIME
AS
BEGIN
	-- Declare the return variable here
	DECLARE @Date DATE = GETDATE();
	DECLARE @SmallDate SMALLDATETIME;

	SET @SmallDate = @Date

	-- Return the result of the function
	RETURN @SmallDate

END
GO


