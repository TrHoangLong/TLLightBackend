IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[CustCart]') AND type in (N'U'))
ALTER TABLE [dbo].[CustCart] DROP CONSTRAINT IF EXISTS [FK__CustCart__Produc__78D3EB5B]
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[CustCart]') AND type in (N'U'))
ALTER TABLE [dbo].[CustCart] DROP CONSTRAINT IF EXISTS [FK__CustCart__CustUs__77DFC722]
GO

/****** Object:  Table [dbo].[CustCart]    Script Date: 6/22/2023 7:10:45 PM ******/
DROP TABLE IF EXISTS [dbo].[CustCart]
GO

/****** Object:  Table [dbo].[CustCart]    Script Date: 6/22/2023 7:10:45 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[CustCart](
	[CustCartId] [int] IDENTITY(1,1) NOT NULL,
	[CustUserId] [varchar](30) NOT NULL,
	[ProductId] [varchar](20) NOT NULL,
	[Quantity] [decimal](18, 0) NOT NULL,
	[ProductPrice] [decimal](28, 6) NOT NULL,
	[Status] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CustCartId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[CustCart]  WITH CHECK ADD FOREIGN KEY([CustUserId])
REFERENCES [dbo].[CustomerUser] ([CustUserId])
GO

ALTER TABLE [dbo].[CustCart]  WITH CHECK ADD FOREIGN KEY([ProductId])
REFERENCES [dbo].[Product] ([ProductId])
GO


