/****** Object:  Table [dbo].[Product]    Script Date: 4/10/2023 10:01:11 PM ******/
DROP TABLE IF EXISTS [dbo].[Product]
    GO

/****** Object:  Table [dbo].[Product]    Script Date: 4/10/2023 10:01:11 PM ******/
    SET ANSI_NULLS ON
    GO

    SET QUOTED_IDENTIFIER ON
    GO

CREATE TABLE [dbo].[Product](
    [ProductId] [varchar](20) NOT NULL,
    [CategoryId] [varchar](20) NOT NULL,
    [ProductName] [nvarchar](200) NOT NULL,
    [ProductPrice] [decimal](28, 6) NOT NULL,
    [Description] [ntext] NOT NULL,
    [Quantity] [decimal](18, 0) NOT NULL,
    [ProductImage] [varchar](200) NULL,
    [Status] [int] NOT NULL,
    [CreatedUserId] [varchar](30) NULL,
    [CreatedTime] [datetime2](7) NULL,
    [UpdatedUserId] [varchar](30) NULL,
    [UpdatedTime] [datetime2](7) NULL,
    PRIMARY KEY CLUSTERED
(
[ProductId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO


