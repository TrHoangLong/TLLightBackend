/****** Object:  StoredProcedure [dbo].[SysCartDelete]    Script Date: 6/22/2023 7:40:21 PM ******/
DROP PROCEDURE IF EXISTS [dbo].[SysCartDelete]
GO

/****** Object:  StoredProcedure [dbo].[SysCartDelete]    Script Date: 6/22/2023 7:40:21 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO




CREATE PROCEDURE [dbo].[SysCartDelete]
	@SysCardId INT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	DELETE FROM SysCart WHERE SysCartId = @SysCardId;
END
GO


