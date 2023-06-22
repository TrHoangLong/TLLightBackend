/****** Object:  Table [dbo].[ProductCategories]    Script Date: 6/22/2023 7:14:11 PM ******/
DROP TABLE IF EXISTS [dbo].[ProductCategories]
GO

/****** Object:  Table [dbo].[ProductCategories]    Script Date: 6/22/2023 7:14:11 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ProductCategories](
	[CategoryId] [varchar](20) NOT NULL,
	[CategoryName] [nvarchar](50) NOT NULL,
	[Status] [int] NOT NULL,
	[CreatedUserId] [varchar](30) NULL,
	[CreatedTime] [datetime2](7) NULL,
	[UpdatedUserId] [varchar](30) NULL,
	[UpdatedTime] [datetime2](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[CategoryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


