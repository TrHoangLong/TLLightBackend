IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[CustOrders]') AND type in (N'U'))
ALTER TABLE [dbo].[CustOrders] DROP CONSTRAINT IF EXISTS [FK__CustOrder__Produ__10416098]
GO

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[CustOrders]') AND type in (N'U'))
ALTER TABLE [dbo].[CustOrders] DROP CONSTRAINT IF EXISTS [FK__CustOrder__CustU__0F4D3C5F]
GO

/****** Object:  Table [dbo].[CustOrders]    Script Date: 6/29/2023 12:18:24 AM ******/
DROP TABLE IF EXISTS [dbo].[CustOrders]
GO

/****** Object:  Table [dbo].[CustOrders]    Script Date: 6/29/2023 12:18:24 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[CustOrders](
	[CustOrderDate] [smalldatetime] NOT NULL,
	[CustOrderId] [int] IDENTITY(1,1) NOT NULL,
	[OrderStatus] [int] NOT NULL,
	[CustUserId] [varchar](30) NOT NULL,
	[MobileNo] [varchar](20) NOT NULL,
	[Address] [nvarchar](500) NOT NULL,
	[ProductId] [varchar](20) NOT NULL,
	[Quantity] [decimal](18, 0) NOT NULL,
	[ProductPrice] [decimal](28, 6) NOT NULL,
	[TotalPrice] [decimal](28, 6) NOT NULL,
	[UpdatedUserId] [varchar](30) NULL,
	[UpdatedTime] [datetime2](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[CustOrderDate] ASC,
	[CustOrderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[CustOrders]  WITH CHECK ADD FOREIGN KEY([CustUserId])
REFERENCES [dbo].[CustomerUser] ([CustUserId])
GO

ALTER TABLE [dbo].[CustOrders]  WITH CHECK ADD FOREIGN KEY([ProductId])
REFERENCES [dbo].[Product] ([ProductId])
GO


