package org.sheepy.lily.game.vulkan.swapchain;

import static org.lwjgl.vulkan.VK10.*;

public class ColorDomain
{
	public final int colorFormat;
	public final int colorSpace;

	public ColorDomain(int colorFormat, int colorSpace)
	{
		this.colorFormat = colorFormat;
		this.colorSpace = colorSpace;
	}

	public int getColorFormat()
	{
		return colorFormat;
	}

	public int getColorSpace()
	{
		return colorSpace;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + colorFormat;
		result = prime * result + colorSpace;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		ColorDomain other = (ColorDomain) obj;
		if (colorFormat != other.colorFormat) return false;
		if (colorSpace != other.colorSpace) return false;
		return true;
	}

	@Override
	public String toString()
	{
		return String.format("[%s : %d]", resolveStringFormat(colorFormat), colorSpace);
	}

	public static String resolveStringFormat(int format)
	{
		switch (format)
		{
		case (VK_FORMAT_UNDEFINED):
			return "VK_FORMAT_UNDEFINED";
		case (VK_FORMAT_R4G4_UNORM_PACK8):
			return "VK_FORMAT_R4G4_UNORM_PACK8            ";
		case (VK_FORMAT_R4G4B4A4_UNORM_PACK16):
			return "VK_FORMAT_R4G4B4A4_UNORM_PACK16       ";
		case (VK_FORMAT_B4G4R4A4_UNORM_PACK16):
			return "VK_FORMAT_B4G4R4A4_UNORM_PACK16       ";
		case (VK_FORMAT_R5G6B5_UNORM_PACK16):
			return "VK_FORMAT_R5G6B5_UNORM_PACK16         ";
		case (VK_FORMAT_B5G6R5_UNORM_PACK16):
			return "VK_FORMAT_B5G6R5_UNORM_PACK16         ";
		case (VK_FORMAT_R5G5B5A1_UNORM_PACK16):
			return "VK_FORMAT_R5G5B5A1_UNORM_PACK16       ";
		case (VK_FORMAT_B5G5R5A1_UNORM_PACK16):
			return "VK_FORMAT_B5G5R5A1_UNORM_PACK16       ";
		case (VK_FORMAT_A1R5G5B5_UNORM_PACK16):
			return "VK_FORMAT_A1R5G5B5_UNORM_PACK16       ";
		case (VK_FORMAT_R8_UNORM):
			return "VK_FORMAT_R8_UNORM                    ";
		case (VK_FORMAT_R8_SNORM):
			return "VK_FORMAT_R8_SNORM                    ";
		case (VK_FORMAT_R8_USCALED):
			return "VK_FORMAT_R8_USCALED                  ";
		case (VK_FORMAT_R8_SSCALED):
			return "VK_FORMAT_R8_SSCALED                  ";
		case (VK_FORMAT_R8_UINT):
			return "VK_FORMAT_R8_UINT                     ";
		case (VK_FORMAT_R8_SINT):
			return "VK_FORMAT_R8_SINT                     ";
		case (VK_FORMAT_R8_SRGB):
			return "VK_FORMAT_R8_SRGB                     ";
		case (VK_FORMAT_R8G8_UNORM):
			return "VK_FORMAT_R8G8_UNORM                  ";
		case (VK_FORMAT_R8G8_SNORM):
			return "VK_FORMAT_R8G8_SNORM                  ";
		case (VK_FORMAT_R8G8_USCALED):
			return "VK_FORMAT_R8G8_USCALED                ";
		case (VK_FORMAT_R8G8_SSCALED):
			return "VK_FORMAT_R8G8_SSCALED                ";
		case (VK_FORMAT_R8G8_UINT):
			return "VK_FORMAT_R8G8_UINT                   ";
		case (VK_FORMAT_R8G8_SINT):
			return "VK_FORMAT_R8G8_SINT                   ";
		case (VK_FORMAT_R8G8_SRGB):
			return "VK_FORMAT_R8G8_SRGB                   ";
		case (VK_FORMAT_R8G8B8_UNORM):
			return "VK_FORMAT_R8G8B8_UNORM                ";
		case (VK_FORMAT_R8G8B8_SNORM):
			return "VK_FORMAT_R8G8B8_SNORM                ";
		case (VK_FORMAT_R8G8B8_USCALED):
			return "VK_FORMAT_R8G8B8_USCALED              ";
		case (VK_FORMAT_R8G8B8_SSCALED):
			return "VK_FORMAT_R8G8B8_SSCALED              ";
		case (VK_FORMAT_R8G8B8_UINT):
			return "VK_FORMAT_R8G8B8_UINT                 ";
		case (VK_FORMAT_R8G8B8_SINT):
			return "VK_FORMAT_R8G8B8_SINT                 ";
		case (VK_FORMAT_R8G8B8_SRGB):
			return "VK_FORMAT_R8G8B8_SRGB                 ";
		case (VK_FORMAT_B8G8R8_UNORM):
			return "VK_FORMAT_B8G8R8_UNORM                ";
		case (VK_FORMAT_B8G8R8_SNORM):
			return "VK_FORMAT_B8G8R8_SNORM                ";
		case (VK_FORMAT_B8G8R8_USCALED):
			return "VK_FORMAT_B8G8R8_USCALED              ";
		case (VK_FORMAT_B8G8R8_SSCALED):
			return "VK_FORMAT_B8G8R8_SSCALED              ";
		case (VK_FORMAT_B8G8R8_UINT):
			return "VK_FORMAT_B8G8R8_UINT                 ";
		case (VK_FORMAT_B8G8R8_SINT):
			return "VK_FORMAT_B8G8R8_SINT                 ";
		case (VK_FORMAT_B8G8R8_SRGB):
			return "VK_FORMAT_B8G8R8_SRGB                 ";
		case (VK_FORMAT_R8G8B8A8_UNORM):
			return "VK_FORMAT_R8G8B8A8_UNORM              ";
		case (VK_FORMAT_R8G8B8A8_SNORM):
			return "VK_FORMAT_R8G8B8A8_SNORM              ";
		case (VK_FORMAT_R8G8B8A8_USCALED):
			return "VK_FORMAT_R8G8B8A8_USCALED            ";
		case (VK_FORMAT_R8G8B8A8_SSCALED):
			return "VK_FORMAT_R8G8B8A8_SSCALED            ";
		case (VK_FORMAT_R8G8B8A8_UINT):
			return "VK_FORMAT_R8G8B8A8_UINT               ";
		case (VK_FORMAT_R8G8B8A8_SINT):
			return "VK_FORMAT_R8G8B8A8_SINT               ";
		case (VK_FORMAT_R8G8B8A8_SRGB):
			return "VK_FORMAT_R8G8B8A8_SRGB               ";
		case (VK_FORMAT_B8G8R8A8_UNORM):
			return "VK_FORMAT_B8G8R8A8_UNORM              ";
		case (VK_FORMAT_B8G8R8A8_SNORM):
			return "VK_FORMAT_B8G8R8A8_SNORM              ";
		case (VK_FORMAT_B8G8R8A8_USCALED):
			return "VK_FORMAT_B8G8R8A8_USCALED            ";
		case (VK_FORMAT_B8G8R8A8_SSCALED):
			return "VK_FORMAT_B8G8R8A8_SSCALED            ";
		case (VK_FORMAT_B8G8R8A8_UINT):
			return "VK_FORMAT_B8G8R8A8_UINT               ";
		case (VK_FORMAT_B8G8R8A8_SINT):
			return "VK_FORMAT_B8G8R8A8_SINT               ";
		case (VK_FORMAT_B8G8R8A8_SRGB):
			return "VK_FORMAT_B8G8R8A8_SRGB               ";
		case (VK_FORMAT_A8B8G8R8_UNORM_PACK32):
			return "VK_FORMAT_A8B8G8R8_UNORM_PACK32       ";
		case (VK_FORMAT_A8B8G8R8_SNORM_PACK32):
			return "VK_FORMAT_A8B8G8R8_SNORM_PACK32       ";
		case (VK_FORMAT_A8B8G8R8_USCALED_PACK32):
			return "VK_FORMAT_A8B8G8R8_USCALED_PACK32     ";
		case (VK_FORMAT_A8B8G8R8_SSCALED_PACK32):
			return "VK_FORMAT_A8B8G8R8_SSCALED_PACK32     ";
		case (VK_FORMAT_A8B8G8R8_UINT_PACK32):
			return "VK_FORMAT_A8B8G8R8_UINT_PACK32        ";
		case (VK_FORMAT_A8B8G8R8_SINT_PACK32):
			return "VK_FORMAT_A8B8G8R8_SINT_PACK32        ";
		case (VK_FORMAT_A8B8G8R8_SRGB_PACK32):
			return "VK_FORMAT_A8B8G8R8_SRGB_PACK32        ";
		case (VK_FORMAT_A2R10G10B10_UNORM_PACK32):
			return "VK_FORMAT_A2R10G10B10_UNORM_PACK32    ";
		case (VK_FORMAT_A2R10G10B10_SNORM_PACK32):
			return "VK_FORMAT_A2R10G10B10_SNORM_PACK32    ";
		case (VK_FORMAT_A2R10G10B10_USCALED_PACK32):
			return "VK_FORMAT_A2R10G10B10_USCALED_PACK32  ";
		case (VK_FORMAT_A2R10G10B10_SSCALED_PACK32):
			return "VK_FORMAT_A2R10G10B10_SSCALED_PACK32  ";
		case (VK_FORMAT_A2R10G10B10_UINT_PACK32):
			return "VK_FORMAT_A2R10G10B10_UINT_PACK32     ";
		case (VK_FORMAT_A2R10G10B10_SINT_PACK32):
			return "VK_FORMAT_A2R10G10B10_SINT_PACK32     ";
		case (VK_FORMAT_A2B10G10R10_UNORM_PACK32):
			return "VK_FORMAT_A2B10G10R10_UNORM_PACK32    ";
		case (VK_FORMAT_A2B10G10R10_SNORM_PACK32):
			return "VK_FORMAT_A2B10G10R10_SNORM_PACK32    ";
		case (VK_FORMAT_A2B10G10R10_USCALED_PACK32):
			return "VK_FORMAT_A2B10G10R10_USCALED_PACK32  ";
		case (VK_FORMAT_A2B10G10R10_SSCALED_PACK32):
			return "VK_FORMAT_A2B10G10R10_SSCALED_PACK32  ";
		case (VK_FORMAT_A2B10G10R10_UINT_PACK32):
			return "VK_FORMAT_A2B10G10R10_UINT_PACK32     ";
		case (VK_FORMAT_A2B10G10R10_SINT_PACK32):
			return "VK_FORMAT_A2B10G10R10_SINT_PACK32     ";
		case (VK_FORMAT_R16_UNORM):
			return "VK_FORMAT_R16_UNORM                   ";
		case (VK_FORMAT_R16_SNORM):
			return "VK_FORMAT_R16_SNORM                   ";
		case (VK_FORMAT_R16_USCALED):
			return "VK_FORMAT_R16_USCALED                 ";
		case (VK_FORMAT_R16_SSCALED):
			return "VK_FORMAT_R16_SSCALED                 ";
		case (VK_FORMAT_R16_UINT):
			return "VK_FORMAT_R16_UINT                    ";
		case (VK_FORMAT_R16_SINT):
			return "VK_FORMAT_R16_SINT                    ";
		case (VK_FORMAT_R16_SFLOAT):
			return "VK_FORMAT_R16_SFLOAT                  ";
		case (VK_FORMAT_R16G16_UNORM):
			return "VK_FORMAT_R16G16_UNORM                ";
		case (VK_FORMAT_R16G16_SNORM):
			return "VK_FORMAT_R16G16_SNORM                ";
		case (VK_FORMAT_R16G16_USCALED):
			return "VK_FORMAT_R16G16_USCALED              ";
		case (VK_FORMAT_R16G16_SSCALED):
			return "VK_FORMAT_R16G16_SSCALED              ";
		case (VK_FORMAT_R16G16_UINT):
			return "VK_FORMAT_R16G16_UINT                 ";
		case (VK_FORMAT_R16G16_SINT):
			return "VK_FORMAT_R16G16_SINT                 ";
		case (VK_FORMAT_R16G16_SFLOAT):
			return "VK_FORMAT_R16G16_SFLOAT               ";
		case (VK_FORMAT_R16G16B16_UNORM):
			return "VK_FORMAT_R16G16B16_UNORM             ";
		case (VK_FORMAT_R16G16B16_SNORM):
			return "VK_FORMAT_R16G16B16_SNORM             ";
		case (VK_FORMAT_R16G16B16_USCALED):
			return "VK_FORMAT_R16G16B16_USCALED           ";
		case (VK_FORMAT_R16G16B16_SSCALED):
			return "VK_FORMAT_R16G16B16_SSCALED           ";
		case (VK_FORMAT_R16G16B16_UINT):
			return "VK_FORMAT_R16G16B16_UINT              ";
		case (VK_FORMAT_R16G16B16_SINT):
			return "VK_FORMAT_R16G16B16_SINT              ";
		case (VK_FORMAT_R16G16B16_SFLOAT):
			return "VK_FORMAT_R16G16B16_SFLOAT            ";
		case (VK_FORMAT_R16G16B16A16_UNORM):
			return "VK_FORMAT_R16G16B16A16_UNORM          ";
		case (VK_FORMAT_R16G16B16A16_SNORM):
			return "VK_FORMAT_R16G16B16A16_SNORM          ";
		case (VK_FORMAT_R16G16B16A16_USCALED):
			return "VK_FORMAT_R16G16B16A16_USCALED        ";
		case (VK_FORMAT_R16G16B16A16_SSCALED):
			return "VK_FORMAT_R16G16B16A16_SSCALED        ";
		case (VK_FORMAT_R16G16B16A16_UINT):
			return "VK_FORMAT_R16G16B16A16_UINT           ";
		case (VK_FORMAT_R16G16B16A16_SINT):
			return "VK_FORMAT_R16G16B16A16_SINT           ";
		case (VK_FORMAT_R16G16B16A16_SFLOAT):
			return "VK_FORMAT_R16G16B16A16_SFLOAT         ";
		case (VK_FORMAT_R32_UINT):
			return "VK_FORMAT_R32_UINT                    ";
		case (VK_FORMAT_R32_SINT):
			return "VK_FORMAT_R32_SINT                    ";
		case (VK_FORMAT_R32_SFLOAT):
			return "VK_FORMAT_R32_SFLOAT                  ";
		case (VK_FORMAT_R32G32_UINT):
			return "VK_FORMAT_R32G32_UINT                 ";
		case (VK_FORMAT_R32G32_SINT):
			return "VK_FORMAT_R32G32_SINT                 ";
		case (VK_FORMAT_R32G32_SFLOAT):
			return "VK_FORMAT_R32G32_SFLOAT               ";
		case (VK_FORMAT_R32G32B32_UINT):
			return "VK_FORMAT_R32G32B32_UINT              ";
		case (VK_FORMAT_R32G32B32_SINT):
			return "VK_FORMAT_R32G32B32_SINT              ";
		case (VK_FORMAT_R32G32B32_SFLOAT):
			return "VK_FORMAT_R32G32B32_SFLOAT            ";
		case (VK_FORMAT_R32G32B32A32_UINT):
			return "VK_FORMAT_R32G32B32A32_UINT           ";
		case (VK_FORMAT_R32G32B32A32_SINT):
			return "VK_FORMAT_R32G32B32A32_SINT           ";
		case (VK_FORMAT_R32G32B32A32_SFLOAT):
			return "VK_FORMAT_R32G32B32A32_SFLOAT         ";
		case (VK_FORMAT_R64_UINT):
			return "VK_FORMAT_R64_UINT                    ";
		case (VK_FORMAT_R64_SINT):
			return "VK_FORMAT_R64_SINT                    ";
		case (VK_FORMAT_R64_SFLOAT):
			return "VK_FORMAT_R64_SFLOAT                  ";
		case (VK_FORMAT_R64G64_UINT):
			return "VK_FORMAT_R64G64_UINT                 ";
		case (VK_FORMAT_R64G64_SINT):
			return "VK_FORMAT_R64G64_SINT                 ";
		case (VK_FORMAT_R64G64_SFLOAT):
			return "VK_FORMAT_R64G64_SFLOAT               ";
		case (VK_FORMAT_R64G64B64_UINT):
			return "VK_FORMAT_R64G64B64_UINT              ";
		case (VK_FORMAT_R64G64B64_SINT):
			return "VK_FORMAT_R64G64B64_SINT              ";
		case (VK_FORMAT_R64G64B64_SFLOAT):
			return "VK_FORMAT_R64G64B64_SFLOAT            ";
		case (VK_FORMAT_R64G64B64A64_UINT):
			return "VK_FORMAT_R64G64B64A64_UINT           ";
		case (VK_FORMAT_R64G64B64A64_SINT):
			return "VK_FORMAT_R64G64B64A64_SINT           ";
		case (VK_FORMAT_R64G64B64A64_SFLOAT):
			return "VK_FORMAT_R64G64B64A64_SFLOAT         ";
		case (VK_FORMAT_B10G11R11_UFLOAT_PACK32):
			return "VK_FORMAT_B10G11R11_UFLOAT_PACK32     ";
		case (VK_FORMAT_E5B9G9R9_UFLOAT_PACK32):
			return "VK_FORMAT_E5B9G9R9_UFLOAT_PACK32      ";
		case (VK_FORMAT_D16_UNORM):
			return "VK_FORMAT_D16_UNORM                   ";
		case (VK_FORMAT_X8_D24_UNORM_PACK32):
			return "VK_FORMAT_X8_D24_UNORM_PACK32         ";
		case (VK_FORMAT_D32_SFLOAT):
			return "VK_FORMAT_D32_SFLOAT                  ";
		case (VK_FORMAT_S8_UINT):
			return "VK_FORMAT_S8_UINT                     ";
		case (VK_FORMAT_D16_UNORM_S8_UINT):
			return "VK_FORMAT_D16_UNORM_S8_UINT           ";
		case (VK_FORMAT_D24_UNORM_S8_UINT):
			return "VK_FORMAT_D24_UNORM_S8_UINT           ";
		case (VK_FORMAT_D32_SFLOAT_S8_UINT):
			return "VK_FORMAT_D32_SFLOAT_S8_UINT          ";
		case (VK_FORMAT_BC1_RGB_UNORM_BLOCK):
			return "VK_FORMAT_BC1_RGB_UNORM_BLOCK         ";
		case (VK_FORMAT_BC1_RGB_SRGB_BLOCK):
			return "VK_FORMAT_BC1_RGB_SRGB_BLOCK          ";
		case (VK_FORMAT_BC1_RGBA_UNORM_BLOCK):
			return "VK_FORMAT_BC1_RGBA_UNORM_BLOCK        ";
		case (VK_FORMAT_BC1_RGBA_SRGB_BLOCK):
			return "VK_FORMAT_BC1_RGBA_SRGB_BLOCK         ";
		case (VK_FORMAT_BC2_UNORM_BLOCK):
			return "VK_FORMAT_BC2_UNORM_BLOCK             ";
		case (VK_FORMAT_BC2_SRGB_BLOCK):
			return "VK_FORMAT_BC2_SRGB_BLOCK              ";
		case (VK_FORMAT_BC3_UNORM_BLOCK):
			return "VK_FORMAT_BC3_UNORM_BLOCK             ";
		case (VK_FORMAT_BC3_SRGB_BLOCK):
			return "VK_FORMAT_BC3_SRGB_BLOCK              ";
		case (VK_FORMAT_BC4_UNORM_BLOCK):
			return "VK_FORMAT_BC4_UNORM_BLOCK             ";
		case (VK_FORMAT_BC4_SNORM_BLOCK):
			return "VK_FORMAT_BC4_SNORM_BLOCK             ";
		case (VK_FORMAT_BC5_UNORM_BLOCK):
			return "VK_FORMAT_BC5_UNORM_BLOCK             ";
		case (VK_FORMAT_BC5_SNORM_BLOCK):
			return "VK_FORMAT_BC5_SNORM_BLOCK             ";
		case (VK_FORMAT_BC6H_UFLOAT_BLOCK):
			return "VK_FORMAT_BC6H_UFLOAT_BLOCK           ";
		case (VK_FORMAT_BC6H_SFLOAT_BLOCK):
			return "VK_FORMAT_BC6H_SFLOAT_BLOCK           ";
		case (VK_FORMAT_BC7_UNORM_BLOCK):
			return "VK_FORMAT_BC7_UNORM_BLOCK             ";
		case (VK_FORMAT_BC7_SRGB_BLOCK):
			return "VK_FORMAT_BC7_SRGB_BLOCK              ";
		case (VK_FORMAT_ETC2_R8G8B8_UNORM_BLOCK):
			return "VK_FORMAT_ETC2_R8G8B8_UNORM_BLOCK     ";
		case (VK_FORMAT_ETC2_R8G8B8_SRGB_BLOCK):
			return "VK_FORMAT_ETC2_R8G8B8_SRGB_BLOCK      ";
		case (VK_FORMAT_ETC2_R8G8B8A1_UNORM_BLOCK):
			return "VK_FORMAT_ETC2_R8G8B8A1_UNORM_BLOCK   ";
		case (VK_FORMAT_ETC2_R8G8B8A1_SRGB_BLOCK):
			return "VK_FORMAT_ETC2_R8G8B8A1_SRGB_BLOCK    ";
		case (VK_FORMAT_ETC2_R8G8B8A8_UNORM_BLOCK):
			return "VK_FORMAT_ETC2_R8G8B8A8_UNORM_BLOCK   ";
		case (VK_FORMAT_ETC2_R8G8B8A8_SRGB_BLOCK):
			return "VK_FORMAT_ETC2_R8G8B8A8_SRGB_BLOCK    ";
		case (VK_FORMAT_EAC_R11_UNORM_BLOCK):
			return "VK_FORMAT_EAC_R11_UNORM_BLOCK         ";
		case (VK_FORMAT_EAC_R11_SNORM_BLOCK):
			return "VK_FORMAT_EAC_R11_SNORM_BLOCK         ";
		case (VK_FORMAT_EAC_R11G11_UNORM_BLOCK):
			return "VK_FORMAT_EAC_R11G11_UNORM_BLOCK      ";
		case (VK_FORMAT_EAC_R11G11_SNORM_BLOCK):
			return "VK_FORMAT_EAC_R11G11_SNORM_BLOCK      ";
		case (VK_FORMAT_ASTC_4x4_UNORM_BLOCK):
			return "VK_FORMAT_ASTC_4x4_UNORM_BLOCK        ";
		case (VK_FORMAT_ASTC_4x4_SRGB_BLOCK):
			return "VK_FORMAT_ASTC_4x4_SRGB_BLOCK         ";
		case (VK_FORMAT_ASTC_5x4_UNORM_BLOCK):
			return "VK_FORMAT_ASTC_5x4_UNORM_BLOCK        ";
		case (VK_FORMAT_ASTC_5x4_SRGB_BLOCK):
			return "VK_FORMAT_ASTC_5x4_SRGB_BLOCK         ";
		case (VK_FORMAT_ASTC_5x5_UNORM_BLOCK):
			return "VK_FORMAT_ASTC_5x5_UNORM_BLOCK        ";
		case (VK_FORMAT_ASTC_5x5_SRGB_BLOCK):
			return "VK_FORMAT_ASTC_5x5_SRGB_BLOCK         ";
		case (VK_FORMAT_ASTC_6x5_UNORM_BLOCK):
			return "VK_FORMAT_ASTC_6x5_UNORM_BLOCK        ";
		case (VK_FORMAT_ASTC_6x5_SRGB_BLOCK):
			return "VK_FORMAT_ASTC_6x5_SRGB_BLOCK         ";
		case (VK_FORMAT_ASTC_6x6_UNORM_BLOCK):
			return "VK_FORMAT_ASTC_6x6_UNORM_BLOCK        ";
		case (VK_FORMAT_ASTC_6x6_SRGB_BLOCK):
			return "VK_FORMAT_ASTC_6x6_SRGB_BLOCK         ";
		case (VK_FORMAT_ASTC_8x5_UNORM_BLOCK):
			return "VK_FORMAT_ASTC_8x5_UNORM_BLOCK        ";
		case (VK_FORMAT_ASTC_8x5_SRGB_BLOCK):
			return "VK_FORMAT_ASTC_8x5_SRGB_BLOCK         ";
		case (VK_FORMAT_ASTC_8x6_UNORM_BLOCK):
			return "VK_FORMAT_ASTC_8x6_UNORM_BLOCK        ";
		case (VK_FORMAT_ASTC_8x6_SRGB_BLOCK):
			return "VK_FORMAT_ASTC_8x6_SRGB_BLOCK         ";
		case (VK_FORMAT_ASTC_8x8_UNORM_BLOCK):
			return "VK_FORMAT_ASTC_8x8_UNORM_BLOCK        ";
		case (VK_FORMAT_ASTC_8x8_SRGB_BLOCK):
			return "VK_FORMAT_ASTC_8x8_SRGB_BLOCK         ";
		case (VK_FORMAT_ASTC_10x5_UNORM_BLOCK):
			return "VK_FORMAT_ASTC_10x5_UNORM_BLOCK       ";
		case (VK_FORMAT_ASTC_10x5_SRGB_BLOCK):
			return "VK_FORMAT_ASTC_10x5_SRGB_BLOCK        ";
		case (VK_FORMAT_ASTC_10x6_UNORM_BLOCK):
			return "VK_FORMAT_ASTC_10x6_UNORM_BLOCK       ";
		case (VK_FORMAT_ASTC_10x6_SRGB_BLOCK):
			return "VK_FORMAT_ASTC_10x6_SRGB_BLOCK        ";
		case (VK_FORMAT_ASTC_10x8_UNORM_BLOCK):
			return "VK_FORMAT_ASTC_10x8_UNORM_BLOCK       ";
		case (VK_FORMAT_ASTC_10x8_SRGB_BLOCK):
			return "VK_FORMAT_ASTC_10x8_SRGB_BLOCK        ";
		case (VK_FORMAT_ASTC_10x10_UNORM_BLOCK):
			return "VK_FORMAT_ASTC_10x10_UNORM_BLOCK      ";
		case (VK_FORMAT_ASTC_10x10_SRGB_BLOCK):
			return "VK_FORMAT_ASTC_10x10_SRGB_BLOCK       ";
		case (VK_FORMAT_ASTC_12x10_UNORM_BLOCK):
			return "VK_FORMAT_ASTC_12x10_UNORM_BLOCK      ";
		case (VK_FORMAT_ASTC_12x10_SRGB_BLOCK):
			return "VK_FORMAT_ASTC_12x10_SRGB_BLOCK       ";
		case (VK_FORMAT_ASTC_12x12_UNORM_BLOCK):
			return "VK_FORMAT_ASTC_12x12_UNORM_BLOCK      ";
		case (VK_FORMAT_ASTC_12x12_SRGB_BLOCK):
			return "VK_FORMAT_ASTC_12x12_SRGB_BLOCK       ";
		}

		return null;
	}
}