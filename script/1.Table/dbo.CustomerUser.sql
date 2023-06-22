/****** Object:  Table [dbo].[CustomerUser]    Script Date: 6/22/2023 7:11:38 PM ******/
DROP TABLE IF EXISTS [dbo].[CustomerUser]
GO

/****** Object:  Table [dbo].[CustomerUser]    Script Date: 6/22/2023 7:11:38 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[CustomerUser](
	[CustUserId] [varchar](30) NOT NULL,
	[Password] [varchar](100) NOT NULL,
	[CustName] [nvarchar](50) NOT NULL,
	[Gender] [int] NULL,
	[Birthday] [date] NULL,
	[MobileNo] [varchar](13) NOT NULL,
	[Email] [varchar](50) NULL,
	[Address] [nvarchar](500) NOT NULL,
	[Status] [int] NOT NULL,
	[Remarks] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[CustUserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


