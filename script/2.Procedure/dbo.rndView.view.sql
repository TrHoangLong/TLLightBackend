/****** Object:  View [dbo].[rndView]    Script Date: 6/22/2023 7:19:29 PM ******/
DROP VIEW IF EXISTS [dbo].[rndView]
GO

/****** Object:  View [dbo].[rndView]    Script Date: 6/22/2023 7:19:29 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE VIEW [dbo].[rndView] AS
	SELECT RAND() rndResult
GO


