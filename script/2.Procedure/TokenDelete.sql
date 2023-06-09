/****** Object:  StoredProcedure [dbo].[TokenDelete]    Script Date: 6/22/2023 7:45:14 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[TokenDelete]
GO

/****** Object:  StoredProcedure [dbo].[TokenDelete]    Script Date: 6/22/2023 7:45:14 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[TokenDelete] 
	@Token VARCHAR(500)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    DELETE FROM Token
	WHERE Token LIKE @Token;
END
GO


