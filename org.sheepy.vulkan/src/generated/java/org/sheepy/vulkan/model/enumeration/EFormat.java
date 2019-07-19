/**
 */
package org.sheepy.vulkan.model.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EFormat</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.enumeration.EnumerationPackage#getEFormat()
 * @model
 * @generated
 */
public enum EFormat implements Enumerator
{
	/**
	 * The '<em><b>UNDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	UNDEFINED(0, "UNDEFINED", "UNDEFINED"),

	/**
	 * The '<em><b>R4G4 UNORM PACK8</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R4G4_UNORM_PACK8_VALUE
	 * @generated
	 * @ordered
	 */
	R4G4_UNORM_PACK8(1, "R4G4_UNORM_PACK8", "R4G4_UNORM_PACK8"),

	/**
	 * The '<em><b>R4G4B4A4 UNORM PACK16</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R4G4B4A4_UNORM_PACK16_VALUE
	 * @generated
	 * @ordered
	 */
	R4G4B4A4_UNORM_PACK16(2, "R4G4B4A4_UNORM_PACK16", "R4G4B4A4_UNORM_PACK16"),

	/**
	 * The '<em><b>B4G4R4A4 UNORM PACK16</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B4G4R4A4_UNORM_PACK16_VALUE
	 * @generated
	 * @ordered
	 */
	B4G4R4A4_UNORM_PACK16(3, "B4G4R4A4_UNORM_PACK16", "B4G4R4A4_UNORM_PACK16"),

	/**
	 * The '<em><b>R5G6B5 UNORM PACK16</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R5G6B5_UNORM_PACK16_VALUE
	 * @generated
	 * @ordered
	 */
	R5G6B5_UNORM_PACK16(4, "R5G6B5_UNORM_PACK16", "R5G6B5_UNORM_PACK16"),

	/**
	 * The '<em><b>B5G6R5 UNORM PACK16</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B5G6R5_UNORM_PACK16_VALUE
	 * @generated
	 * @ordered
	 */
	B5G6R5_UNORM_PACK16(5, "B5G6R5_UNORM_PACK16", "B5G6R5_UNORM_PACK16"),

	/**
	 * The '<em><b>R5G5B5A1 UNORM PACK16</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R5G5B5A1_UNORM_PACK16_VALUE
	 * @generated
	 * @ordered
	 */
	R5G5B5A1_UNORM_PACK16(6, "R5G5B5A1_UNORM_PACK16", "R5G5B5A1_UNORM_PACK16"),

	/**
	 * The '<em><b>B5G5R5A1 UNORM PACK16</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B5G5R5A1_UNORM_PACK16_VALUE
	 * @generated
	 * @ordered
	 */
	B5G5R5A1_UNORM_PACK16(7, "B5G5R5A1_UNORM_PACK16", "B5G5R5A1_UNORM_PACK16"),

	/**
	 * The '<em><b>A1R5G5B5 UNORM PACK16</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A1R5G5B5_UNORM_PACK16_VALUE
	 * @generated
	 * @ordered
	 */
	A1R5G5B5_UNORM_PACK16(8, "A1R5G5B5_UNORM_PACK16", "A1R5G5B5_UNORM_PACK16"),

	/**
	 * The '<em><b>R8 UNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8_UNORM_VALUE
	 * @generated
	 * @ordered
	 */
	R8_UNORM(9, "R8_UNORM", "R8_UNORM"),

	/**
	 * The '<em><b>R8 SNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8_SNORM_VALUE
	 * @generated
	 * @ordered
	 */
	R8_SNORM(10, "R8_SNORM", "R8_SNORM"),

	/**
	 * The '<em><b>R8 USCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8_USCALED_VALUE
	 * @generated
	 * @ordered
	 */
	R8_USCALED(11, "R8_USCALED", "R8_USCALED"),

	/**
	 * The '<em><b>R8 SSCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8_SSCALED_VALUE
	 * @generated
	 * @ordered
	 */
	R8_SSCALED(12, "R8_SSCALED", "R8_SSCALED"),

	/**
	 * The '<em><b>R8 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	R8_UINT(13, "R8_UINT", "R8_UINT"),

	/**
	 * The '<em><b>R8 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	R8_SINT(14, "R8_SINT", "R8_SINT"),

	/**
	 * The '<em><b>R8 SRGB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8_SRGB_VALUE
	 * @generated
	 * @ordered
	 */
	R8_SRGB(15, "R8_SRGB", "R8_SRGB"),

	/**
	 * The '<em><b>R8G8 UNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8_UNORM_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8_UNORM(16, "R8G8_UNORM", "R8G8_UNORM"),

	/**
	 * The '<em><b>R8G8 SNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8_SNORM_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8_SNORM(17, "R8G8_SNORM", "R8G8_SNORM"),

	/**
	 * The '<em><b>R8G8 USCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8_USCALED_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8_USCALED(18, "R8G8_USCALED", "R8G8_USCALED"),

	/**
	 * The '<em><b>R8G8 SSCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8_SSCALED_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8_SSCALED(19, "R8G8_SSCALED", "R8G8_SSCALED"),

	/**
	 * The '<em><b>R8G8 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8_UINT(20, "R8G8_UINT", "R8G8_UINT"),

	/**
	 * The '<em><b>R8G8 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8_SINT(21, "R8G8_SINT", "R8G8_SINT"),

	/**
	 * The '<em><b>R8G8 SRGB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8_SRGB_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8_SRGB(22, "R8G8_SRGB", "R8G8_SRGB"),

	/**
	 * The '<em><b>R8G8B8 UNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8_UNORM_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8B8_UNORM(23, "R8G8B8_UNORM", "R8G8B8_UNORM"),

	/**
	 * The '<em><b>R8G8B8 SNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8_SNORM_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8B8_SNORM(24, "R8G8B8_SNORM", "R8G8B8_SNORM"),

	/**
	 * The '<em><b>R8G8B8 USCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8_USCALED_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8B8_USCALED(25, "R8G8B8_USCALED", "R8G8B8_USCALED"),

	/**
	 * The '<em><b>R8G8B8 SSCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8_SSCALED_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8B8_SSCALED(26, "R8G8B8_SSCALED", "R8G8B8_SSCALED"),

	/**
	 * The '<em><b>R8G8B8 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8B8_UINT(27, "R8G8B8_UINT", "R8G8B8_UINT"),

	/**
	 * The '<em><b>R8G8B8 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8B8_SINT(28, "R8G8B8_SINT", "R8G8B8_SINT"),

	/**
	 * The '<em><b>R8G8B8 SRGB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8_SRGB_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8B8_SRGB(29, "R8G8B8_SRGB", "R8G8B8_SRGB"),

	/**
	 * The '<em><b>B8G8R8 UNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8_UNORM_VALUE
	 * @generated
	 * @ordered
	 */
	B8G8R8_UNORM(30, "B8G8R8_UNORM", "B8G8R8_UNORM"),

	/**
	 * The '<em><b>B8G8R8 SNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8_SNORM_VALUE
	 * @generated
	 * @ordered
	 */
	B8G8R8_SNORM(31, "B8G8R8_SNORM", "B8G8R8_SNORM"),

	/**
	 * The '<em><b>B8G8R8 USCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8_USCALED_VALUE
	 * @generated
	 * @ordered
	 */
	B8G8R8_USCALED(32, "B8G8R8_USCALED", "B8G8R8_USCALED"),

	/**
	 * The '<em><b>B8G8R8 SSCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8_SSCALED_VALUE
	 * @generated
	 * @ordered
	 */
	B8G8R8_SSCALED(33, "B8G8R8_SSCALED", "B8G8R8_SSCALED"),

	/**
	 * The '<em><b>B8G8R8 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	B8G8R8_UINT(34, "B8G8R8_UINT", "B8G8R8_UINT"),

	/**
	 * The '<em><b>B8G8R8 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	B8G8R8_SINT(35, "B8G8R8_SINT", "B8G8R8_SINT"),

	/**
	 * The '<em><b>B8G8R8 SRGB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8_SRGB_VALUE
	 * @generated
	 * @ordered
	 */
	B8G8R8_SRGB(36, "B8G8R8_SRGB", "B8G8R8_SRGB"),

	/**
	 * The '<em><b>R8G8B8A8 UNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8A8_UNORM_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8B8A8_UNORM(37, "R8G8B8A8_UNORM", "R8G8B8A8_UNORM"),

	/**
	 * The '<em><b>R8G8B8A8 SNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8A8_SNORM_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8B8A8_SNORM(38, "R8G8B8A8_SNORM", "R8G8B8A8_SNORM"),

	/**
	 * The '<em><b>R8G8B8A8 USCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8A8_USCALED_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8B8A8_USCALED(39, "R8G8B8A8_USCALED", "R8G8B8A8_USCALED"),

	/**
	 * The '<em><b>R8G8B8A8 SSCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8A8_SSCALED_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8B8A8_SSCALED(40, "R8G8B8A8_SSCALED", "R8G8B8A8_SSCALED"),

	/**
	 * The '<em><b>R8G8B8A8 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8A8_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8B8A8_UINT(41, "R8G8B8A8_UINT", "R8G8B8A8_UINT"),

	/**
	 * The '<em><b>R8G8B8A8 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8A8_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8B8A8_SINT(42, "R8G8B8A8_SINT", "R8G8B8A8_SINT"),

	/**
	 * The '<em><b>R8G8B8A8 SRGB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8A8_SRGB_VALUE
	 * @generated
	 * @ordered
	 */
	R8G8B8A8_SRGB(43, "R8G8B8A8_SRGB", "R8G8B8A8_SRGB"),

	/**
	 * The '<em><b>B8G8R8A8 UNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8A8_UNORM_VALUE
	 * @generated
	 * @ordered
	 */
	B8G8R8A8_UNORM(44, "B8G8R8A8_UNORM", "B8G8R8A8_UNORM"),

	/**
	 * The '<em><b>B8G8R8A8 SNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8A8_SNORM_VALUE
	 * @generated
	 * @ordered
	 */
	B8G8R8A8_SNORM(45, "B8G8R8A8_SNORM", "B8G8R8A8_SNORM"),

	/**
	 * The '<em><b>B8G8R8A8 USCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8A8_USCALED_VALUE
	 * @generated
	 * @ordered
	 */
	B8G8R8A8_USCALED(46, "B8G8R8A8_USCALED", "B8G8R8A8_USCALED"),

	/**
	 * The '<em><b>B8G8R8A8 SSCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8A8_SSCALED_VALUE
	 * @generated
	 * @ordered
	 */
	B8G8R8A8_SSCALED(47, "B8G8R8A8_SSCALED", "B8G8R8A8_SSCALED"),

	/**
	 * The '<em><b>B8G8R8A8 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8A8_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	B8G8R8A8_UINT(48, "B8G8R8A8_UINT", "B8G8R8A8_UINT"),

	/**
	 * The '<em><b>B8G8R8A8 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8A8_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	B8G8R8A8_SINT(49, "B8G8R8A8_SINT", "B8G8R8A8_SINT"),

	/**
	 * The '<em><b>B8G8R8A8 SRGB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8A8_SRGB_VALUE
	 * @generated
	 * @ordered
	 */
	B8G8R8A8_SRGB(50, "B8G8R8A8_SRGB", "B8G8R8A8_SRGB"),

	/**
	 * The '<em><b>A8B8G8R8 UNORM PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A8B8G8R8_UNORM_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A8B8G8R8_UNORM_PACK32(51, "A8B8G8R8_UNORM_PACK32", "A8B8G8R8_UNORM_PACK32"),

	/**
	 * The '<em><b>A8B8G8R8 SNORM PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A8B8G8R8_SNORM_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A8B8G8R8_SNORM_PACK32(52, "A8B8G8R8_SNORM_PACK32", "A8B8G8R8_SNORM_PACK32"),

	/**
	 * The '<em><b>A8B8G8R8 USCALED PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A8B8G8R8_USCALED_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A8B8G8R8_USCALED_PACK32(53, "A8B8G8R8_USCALED_PACK32", "A8B8G8R8_USCALED_PACK32"),

	/**
	 * The '<em><b>A8B8G8R8 SSCALED PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A8B8G8R8_SSCALED_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A8B8G8R8_SSCALED_PACK32(54, "A8B8G8R8_SSCALED_PACK32", "A8B8G8R8_SSCALED_PACK32"),

	/**
	 * The '<em><b>A8B8G8R8 UINT PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A8B8G8R8_UINT_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A8B8G8R8_UINT_PACK32(55, "A8B8G8R8_UINT_PACK32", "A8B8G8R8_UINT_PACK32"),

	/**
	 * The '<em><b>A8B8G8R8 SINT PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A8B8G8R8_SINT_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A8B8G8R8_SINT_PACK32(56, "A8B8G8R8_SINT_PACK32", "A8B8G8R8_SINT_PACK32"),

	/**
	 * The '<em><b>A8B8G8R8 SRGB PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A8B8G8R8_SRGB_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A8B8G8R8_SRGB_PACK32(57, "A8B8G8R8_SRGB_PACK32", "A8B8G8R8_SRGB_PACK32"),

	/**
	 * The '<em><b>A2R10G10B10 UNORM PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2R10G10B10_UNORM_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A2R10G10B10_UNORM_PACK32(58, "A2R10G10B10_UNORM_PACK32", "A2R10G10B10_UNORM_PACK32"),

	/**
	 * The '<em><b>A2R10G10B10 SNORM PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2R10G10B10_SNORM_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A2R10G10B10_SNORM_PACK32(59, "A2R10G10B10_SNORM_PACK32", "A2R10G10B10_SNORM_PACK32"),

	/**
	 * The '<em><b>A2R10G10B10 USCALED PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2R10G10B10_USCALED_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A2R10G10B10_USCALED_PACK32(60, "A2R10G10B10_USCALED_PACK32", "A2R10G10B10_USCALED_PACK32"),

	/**
	 * The '<em><b>A2R10G10B10 SSCALED PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2R10G10B10_SSCALED_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A2R10G10B10_SSCALED_PACK32(61, "A2R10G10B10_SSCALED_PACK32", "A2R10G10B10_SSCALED_PACK32"),

	/**
	 * The '<em><b>A2R10G10B10 UINT PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2R10G10B10_UINT_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A2R10G10B10_UINT_PACK32(62, "A2R10G10B10_UINT_PACK32", "A2R10G10B10_UINT_PACK32"),

	/**
	 * The '<em><b>A2R10G10B10 SINT PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2R10G10B10_SINT_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A2R10G10B10_SINT_PACK32(63, "A2R10G10B10_SINT_PACK32", "A2R10G10B10_SINT_PACK32"),

	/**
	 * The '<em><b>A2B10G10R10 UNORM PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2B10G10R10_UNORM_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A2B10G10R10_UNORM_PACK32(64, "A2B10G10R10_UNORM_PACK32", "A2B10G10R10_UNORM_PACK32"),

	/**
	 * The '<em><b>A2B10G10R10 SNORM PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2B10G10R10_SNORM_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A2B10G10R10_SNORM_PACK32(65, "A2B10G10R10_SNORM_PACK32", "A2B10G10R10_SNORM_PACK32"),

	/**
	 * The '<em><b>A2B10G10R10 USCALED PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2B10G10R10_USCALED_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A2B10G10R10_USCALED_PACK32(66, "A2B10G10R10_USCALED_PACK32", "A2B10G10R10_USCALED_PACK32"),

	/**
	 * The '<em><b>A2B10G10R10 SSCALED PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2B10G10R10_SSCALED_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A2B10G10R10_SSCALED_PACK32(67, "A2B10G10R10_SSCALED_PACK32", "A2B10G10R10_SSCALED_PACK32"),

	/**
	 * The '<em><b>A2B10G10R10 UINT PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2B10G10R10_UINT_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A2B10G10R10_UINT_PACK32(68, "A2B10G10R10_UINT_PACK32", "A2B10G10R10_UINT_PACK32"),

	/**
	 * The '<em><b>A2B10G10R10 SINT PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2B10G10R10_SINT_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	A2B10G10R10_SINT_PACK32(69, "A2B10G10R10_SINT_PACK32", "A2B10G10R10_SINT_PACK32"),

	/**
	 * The '<em><b>R16 UNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16_UNORM_VALUE
	 * @generated
	 * @ordered
	 */
	R16_UNORM(70, "R16_UNORM", "R16_UNORM"),

	/**
	 * The '<em><b>R16 SNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16_SNORM_VALUE
	 * @generated
	 * @ordered
	 */
	R16_SNORM(71, "R16_SNORM", "R16_SNORM"),

	/**
	 * The '<em><b>R16 USCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16_USCALED_VALUE
	 * @generated
	 * @ordered
	 */
	R16_USCALED(72, "R16_USCALED", "R16_USCALED"),

	/**
	 * The '<em><b>R16 SSCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16_SSCALED_VALUE
	 * @generated
	 * @ordered
	 */
	R16_SSCALED(73, "R16_SSCALED", "R16_SSCALED"),

	/**
	 * The '<em><b>R16 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	R16_UINT(74, "R16_UINT", "R16_UINT"),

	/**
	 * The '<em><b>R16 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	R16_SINT(75, "R16_SINT", "R16_SINT"),

	/**
	 * The '<em><b>R16 SFLOAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16_SFLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	R16_SFLOAT(76, "R16_SFLOAT", "R16_SFLOAT"),

	/**
	 * The '<em><b>R16G16 UNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16_UNORM_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16_UNORM(77, "R16G16_UNORM", "R16G16_UNORM"),

	/**
	 * The '<em><b>R16G16 SNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16_SNORM_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16_SNORM(78, "R16G16_SNORM", "R16G16_SNORM"),

	/**
	 * The '<em><b>R16G16 USCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16_USCALED_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16_USCALED(79, "R16G16_USCALED", "R16G16_USCALED"),

	/**
	 * The '<em><b>R16G16 SSCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16_SSCALED_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16_SSCALED(80, "R16G16_SSCALED", "R16G16_SSCALED"),

	/**
	 * The '<em><b>R16G16 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16_UINT(81, "R16G16_UINT", "R16G16_UINT"),

	/**
	 * The '<em><b>R16G16 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16_SINT(82, "R16G16_SINT", "R16G16_SINT"),

	/**
	 * The '<em><b>R16G16 SFLOAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16_SFLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16_SFLOAT(83, "R16G16_SFLOAT", "R16G16_SFLOAT"),

	/**
	 * The '<em><b>R16G16B16 UNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16_UNORM_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16B16_UNORM(84, "R16G16B16_UNORM", "R16G16B16_UNORM"),

	/**
	 * The '<em><b>R16G16B16 SNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16_SNORM_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16B16_SNORM(85, "R16G16B16_SNORM", "R16G16B16_SNORM"),

	/**
	 * The '<em><b>R16G16B16 USCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16_USCALED_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16B16_USCALED(86, "R16G16B16_USCALED", "R16G16B16_USCALED"),

	/**
	 * The '<em><b>R16G16B16 SSCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16_SSCALED_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16B16_SSCALED(87, "R16G16B16_SSCALED", "R16G16B16_SSCALED"),

	/**
	 * The '<em><b>R16G16B16 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16B16_UINT(88, "R16G16B16_UINT", "R16G16B16_UINT"),

	/**
	 * The '<em><b>R16G16B16 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16B16_SINT(89, "R16G16B16_SINT", "R16G16B16_SINT"),

	/**
	 * The '<em><b>R16G16B16 SFLOAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16_SFLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16B16_SFLOAT(90, "R16G16B16_SFLOAT", "R16G16B16_SFLOAT"),

	/**
	 * The '<em><b>R16G16B16A16 UNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16A16_UNORM_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16B16A16_UNORM(91, "R16G16B16A16_UNORM", "R16G16B16A16_UNORM"),

	/**
	 * The '<em><b>R16G16B16A16 SNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16A16_SNORM_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16B16A16_SNORM(92, "R16G16B16A16_SNORM", "R16G16B16A16_SNORM"),

	/**
	 * The '<em><b>R16G16B16A16 USCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16A16_USCALED_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16B16A16_USCALED(93, "R16G16B16A16_USCALED", "R16G16B16A16_USCALED"),

	/**
	 * The '<em><b>R16G16B16A16 SSCALED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16A16_SSCALED_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16B16A16_SSCALED(94, "R16G16B16A16_SSCALED", "R16G16B16A16_SSCALED"),

	/**
	 * The '<em><b>R16G16B16A16 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16A16_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16B16A16_UINT(95, "R16G16B16A16_UINT", "R16G16B16A16_UINT"),

	/**
	 * The '<em><b>R16G16B16A16 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16A16_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16B16A16_SINT(96, "R16G16B16A16_SINT", "R16G16B16A16_SINT"),

	/**
	 * The '<em><b>R16G16B16A16 SFLOAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16A16_SFLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	R16G16B16A16_SFLOAT(97, "R16G16B16A16_SFLOAT", "R16G16B16A16_SFLOAT"),

	/**
	 * The '<em><b>R32 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	R32_UINT(98, "R32_UINT", "R32_UINT"),

	/**
	 * The '<em><b>R32 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	R32_SINT(99, "R32_SINT", "R32_SINT"),

	/**
	 * The '<em><b>R32 SFLOAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32_SFLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	R32_SFLOAT(100, "R32_SFLOAT", "R32_SFLOAT"),

	/**
	 * The '<em><b>R32G32 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	R32G32_UINT(101, "R32G32_UINT", "R32G32_UINT"),

	/**
	 * The '<em><b>R32G32 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	R32G32_SINT(102, "R32G32_SINT", "R32G32_SINT"),

	/**
	 * The '<em><b>R32G32 SFLOAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32_SFLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	R32G32_SFLOAT(103, "R32G32_SFLOAT", "R32G32_SFLOAT"),

	/**
	 * The '<em><b>R32G32B32 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32B32_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	R32G32B32_UINT(104, "R32G32B32_UINT", "R32G32B32_UINT"),

	/**
	 * The '<em><b>R32G32B32 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32B32_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	R32G32B32_SINT(105, "R32G32B32_SINT", "R32G32B32_SINT"),

	/**
	 * The '<em><b>R32G32B32 SFLOAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32B32_SFLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	R32G32B32_SFLOAT(106, "R32G32B32_SFLOAT", "R32G32B32_SFLOAT"),

	/**
	 * The '<em><b>R32G32B32A32 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32B32A32_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	R32G32B32A32_UINT(107, "R32G32B32A32_UINT", "R32G32B32A32_UINT"),

	/**
	 * The '<em><b>R32G32B32A32 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32B32A32_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	R32G32B32A32_SINT(108, "R32G32B32A32_SINT", "R32G32B32A32_SINT"),

	/**
	 * The '<em><b>R32G32B32A32 SFLOAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32B32A32_SFLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	R32G32B32A32_SFLOAT(109, "R32G32B32A32_SFLOAT", "R32G32B32A32_SFLOAT"),

	/**
	 * The '<em><b>R64 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	R64_UINT(110, "R64_UINT", "R64_UINT"),

	/**
	 * The '<em><b>R64 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	R64_SINT(111, "R64_SINT", "R64_SINT"),

	/**
	 * The '<em><b>R64 SFLOAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64_SFLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	R64_SFLOAT(112, "R64_SFLOAT", "R64_SFLOAT"),

	/**
	 * The '<em><b>R64G64 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	R64G64_UINT(113, "R64G64_UINT", "R64G64_UINT"),

	/**
	 * The '<em><b>R64G64 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	R64G64_SINT(114, "R64G64_SINT", "R64G64_SINT"),

	/**
	 * The '<em><b>R64G64 SFLOAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64_SFLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	R64G64_SFLOAT(115, "R64G64_SFLOAT", "R64G64_SFLOAT"),

	/**
	 * The '<em><b>R64G64B64 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64B64_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	R64G64B64_UINT(116, "R64G64B64_UINT", "R64G64B64_UINT"),

	/**
	 * The '<em><b>R64G64B64 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64B64_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	R64G64B64_SINT(117, "R64G64B64_SINT", "R64G64B64_SINT"),

	/**
	 * The '<em><b>R64G64B64 SFLOAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64B64_SFLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	R64G64B64_SFLOAT(118, "R64G64B64_SFLOAT", "R64G64B64_SFLOAT"),

	/**
	 * The '<em><b>R64G64B64A64 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64B64A64_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	R64G64B64A64_UINT(119, "R64G64B64A64_UINT", "R64G64B64A64_UINT"),

	/**
	 * The '<em><b>R64G64B64A64 SINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64B64A64_SINT_VALUE
	 * @generated
	 * @ordered
	 */
	R64G64B64A64_SINT(120, "R64G64B64A64_SINT", "R64G64B64A64_SINT"),

	/**
	 * The '<em><b>R64G64B64A64 SFLOAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64B64A64_SFLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	R64G64B64A64_SFLOAT(121, "R64G64B64A64_SFLOAT", "R64G64B64A64_SFLOAT"),

	/**
	 * The '<em><b>B10G11R11 UFLOAT PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B10G11R11_UFLOAT_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	B10G11R11_UFLOAT_PACK32(122, "B10G11R11_UFLOAT_PACK32", "B10G11R11_UFLOAT_PACK32"),

	/**
	 * The '<em><b>E5B9G9R9 UFLOAT PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #E5B9G9R9_UFLOAT_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	E5B9G9R9_UFLOAT_PACK32(123, "E5B9G9R9_UFLOAT_PACK32", "E5B9G9R9_UFLOAT_PACK32"),

	/**
	 * The '<em><b>D16 UNORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #D16_UNORM_VALUE
	 * @generated
	 * @ordered
	 */
	D16_UNORM(124, "D16_UNORM", "D16_UNORM"),

	/**
	 * The '<em><b>X8 D24 UNORM PACK32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #X8_D24_UNORM_PACK32_VALUE
	 * @generated
	 * @ordered
	 */
	X8_D24_UNORM_PACK32(125, "X8_D24_UNORM_PACK32", "X8_D24_UNORM_PACK32"),

	/**
	 * The '<em><b>D32 SFLOAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #D32_SFLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	D32_SFLOAT(126, "D32_SFLOAT", "D32_SFLOAT"),

	/**
	 * The '<em><b>S8 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #S8_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	S8_UINT(127, "S8_UINT", "S8_UINT"),

	/**
	 * The '<em><b>D16 UNORM S8 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #D16_UNORM_S8_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	D16_UNORM_S8_UINT(128, "D16_UNORM_S8_UINT", "D16_UNORM_S8_UINT"),

	/**
	 * The '<em><b>D24 UNORM S8 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #D24_UNORM_S8_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	D24_UNORM_S8_UINT(129, "D24_UNORM_S8_UINT", "D24_UNORM_S8_UINT"),

	/**
	 * The '<em><b>D32 SFLOAT S8 UINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #D32_SFLOAT_S8_UINT_VALUE
	 * @generated
	 * @ordered
	 */
	D32_SFLOAT_S8_UINT(130, "D32_SFLOAT_S8_UINT", "D32_SFLOAT_S8_UINT"),

	/**
	 * The '<em><b>BC1 RGB UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC1_RGB_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BC1_RGB_UNORM_BLOCK(131, "BC1_RGB_UNORM_BLOCK", "BC1_RGB_UNORM_BLOCK"),

	/**
	 * The '<em><b>BC1 RGB SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC1_RGB_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BC1_RGB_SRGB_BLOCK(132, "BC1_RGB_SRGB_BLOCK", "BC1_RGB_SRGB_BLOCK"),

	/**
	 * The '<em><b>BC1 RGBA UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC1_RGBA_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BC1_RGBA_UNORM_BLOCK(133, "BC1_RGBA_UNORM_BLOCK", "BC1_RGBA_UNORM_BLOCK"),

	/**
	 * The '<em><b>BC1 RGBA SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC1_RGBA_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BC1_RGBA_SRGB_BLOCK(134, "BC1_RGBA_SRGB_BLOCK", "BC1_RGBA_SRGB_BLOCK"),

	/**
	 * The '<em><b>BC2 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC2_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BC2_UNORM_BLOCK(135, "BC2_UNORM_BLOCK", "BC2_UNORM_BLOCK"),

	/**
	 * The '<em><b>BC2 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC2_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BC2_SRGB_BLOCK(136, "BC2_SRGB_BLOCK", "BC2_SRGB_BLOCK"),

	/**
	 * The '<em><b>BC3 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC3_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BC3_UNORM_BLOCK(137, "BC3_UNORM_BLOCK", "BC3_UNORM_BLOCK"),

	/**
	 * The '<em><b>BC3 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC3_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BC3_SRGB_BLOCK(138, "BC3_SRGB_BLOCK", "BC3_SRGB_BLOCK"),

	/**
	 * The '<em><b>BC4 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC4_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BC4_UNORM_BLOCK(139, "BC4_UNORM_BLOCK", "BC4_UNORM_BLOCK"),

	/**
	 * The '<em><b>BC4 SNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC4_SNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BC4_SNORM_BLOCK(140, "BC4_SNORM_BLOCK", "BC4_SNORM_BLOCK"),

	/**
	 * The '<em><b>BC5 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC5_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BC5_UNORM_BLOCK(141, "BC5_UNORM_BLOCK", "BC5_UNORM_BLOCK"),

	/**
	 * The '<em><b>BC5 SNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC5_SNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BC5_SNORM_BLOCK(142, "BC5_SNORM_BLOCK", "BC5_SNORM_BLOCK"),

	/**
	 * The '<em><b>BC6H UFLOAT BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC6H_UFLOAT_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BC6H_UFLOAT_BLOCK(143, "BC6H_UFLOAT_BLOCK", "BC6H_UFLOAT_BLOCK"),

	/**
	 * The '<em><b>BC6H SFLOAT BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC6H_SFLOAT_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BC6H_SFLOAT_BLOCK(144, "BC6H_SFLOAT_BLOCK", "BC6H_SFLOAT_BLOCK"),

	/**
	 * The '<em><b>BC7 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC7_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BC7_UNORM_BLOCK(145, "BC7_UNORM_BLOCK", "BC7_UNORM_BLOCK"),

	/**
	 * The '<em><b>BC7 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC7_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BC7_SRGB_BLOCK(146, "BC7_SRGB_BLOCK", "BC7_SRGB_BLOCK"),

	/**
	 * The '<em><b>ETC2 R8G8B8 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETC2_R8G8B8_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ETC2_R8G8B8_UNORM_BLOCK(147, "ETC2_R8G8B8_UNORM_BLOCK", "ETC2_R8G8B8_UNORM_BLOCK"),

	/**
	 * The '<em><b>ETC2 R8G8B8 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETC2_R8G8B8_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ETC2_R8G8B8_SRGB_BLOCK(148, "ETC2_R8G8B8_SRGB_BLOCK", "ETC2_R8G8B8_SRGB_BLOCK"),

	/**
	 * The '<em><b>ETC2 R8G8B8A1 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETC2_R8G8B8A1_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ETC2_R8G8B8A1_UNORM_BLOCK(149, "ETC2_R8G8B8A1_UNORM_BLOCK", "ETC2_R8G8B8A1_UNORM_BLOCK"),

	/**
	 * The '<em><b>ETC2 R8G8B8A1 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETC2_R8G8B8A1_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ETC2_R8G8B8A1_SRGB_BLOCK(150, "ETC2_R8G8B8A1_SRGB_BLOCK", "ETC2_R8G8B8A1_SRGB_BLOCK"),

	/**
	 * The '<em><b>ETC2 R8G8B8A8 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETC2_R8G8B8A8_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ETC2_R8G8B8A8_UNORM_BLOCK(151, "ETC2_R8G8B8A8_UNORM_BLOCK", "ETC2_R8G8B8A8_UNORM_BLOCK"),

	/**
	 * The '<em><b>ETC2 R8G8B8A8 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETC2_R8G8B8A8_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ETC2_R8G8B8A8_SRGB_BLOCK(152, "ETC2_R8G8B8A8_SRGB_BLOCK", "ETC2_R8G8B8A8_SRGB_BLOCK"),

	/**
	 * The '<em><b>EAC R11 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EAC_R11_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	EAC_R11_UNORM_BLOCK(153, "EAC_R11_UNORM_BLOCK", "EAC_R11_UNORM_BLOCK"),

	/**
	 * The '<em><b>EAC R11 SNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EAC_R11_SNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	EAC_R11_SNORM_BLOCK(154, "EAC_R11_SNORM_BLOCK", "EAC_R11_SNORM_BLOCK"),

	/**
	 * The '<em><b>EAC R11G11 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EAC_R11G11_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	EAC_R11G11_UNORM_BLOCK(155, "EAC_R11G11_UNORM_BLOCK", "EAC_R11G11_UNORM_BLOCK"),

	/**
	 * The '<em><b>EAC R11G11 SNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EAC_R11G11_SNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	EAC_R11G11_SNORM_BLOCK(156, "EAC_R11G11_SNORM_BLOCK", "EAC_R11G11_SNORM_BLOCK"),

	/**
	 * The '<em><b>ASTC 4x4 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_4X4_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_4X4_UNORM_BLOCK(157, "ASTC_4x4_UNORM_BLOCK", "ASTC_4x4_UNORM_BLOCK"),

	/**
	 * The '<em><b>ASTC 4x4 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_4X4_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_4X4_SRGB_BLOCK(158, "ASTC_4x4_SRGB_BLOCK", "ASTC_4x4_SRGB_BLOCK"),

	/**
	 * The '<em><b>ASTC 5x4 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_5X4_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_5X4_UNORM_BLOCK(159, "ASTC_5x4_UNORM_BLOCK", "ASTC_5x4_UNORM_BLOCK"),

	/**
	 * The '<em><b>ASTC 5x4 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_5X4_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_5X4_SRGB_BLOCK(160, "ASTC_5x4_SRGB_BLOCK", "ASTC_5x4_SRGB_BLOCK"),

	/**
	 * The '<em><b>ASTC 5x5 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_5X5_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_5X5_UNORM_BLOCK(161, "ASTC_5x5_UNORM_BLOCK", "ASTC_5x5_UNORM_BLOCK"),

	/**
	 * The '<em><b>ASTC 5x5 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_5X5_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_5X5_SRGB_BLOCK(162, "ASTC_5x5_SRGB_BLOCK", "ASTC_5x5_SRGB_BLOCK"),

	/**
	 * The '<em><b>ASTC 6x5 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_6X5_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_6X5_UNORM_BLOCK(163, "ASTC_6x5_UNORM_BLOCK", "ASTC_6x5_UNORM_BLOCK"),

	/**
	 * The '<em><b>ASTC 6x5 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_6X5_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_6X5_SRGB_BLOCK(164, "ASTC_6x5_SRGB_BLOCK", "ASTC_6x5_SRGB_BLOCK"),

	/**
	 * The '<em><b>ASTC 6x6 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_6X6_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_6X6_UNORM_BLOCK(165, "ASTC_6x6_UNORM_BLOCK", "ASTC_6x6_UNORM_BLOCK"),

	/**
	 * The '<em><b>ASTC 6x6 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_6X6_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_6X6_SRGB_BLOCK(166, "ASTC_6x6_SRGB_BLOCK", "ASTC_6x6_SRGB_BLOCK"),

	/**
	 * The '<em><b>ASTC 8x5 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_8X5_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_8X5_UNORM_BLOCK(167, "ASTC_8x5_UNORM_BLOCK", "ASTC_8x5_UNORM_BLOCK"),

	/**
	 * The '<em><b>ASTC 8x5 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_8X5_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_8X5_SRGB_BLOCK(168, "ASTC_8x5_SRGB_BLOCK", "ASTC_8x5_SRGB_BLOCK"),

	/**
	 * The '<em><b>ASTC 8x6 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_8X6_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_8X6_UNORM_BLOCK(169, "ASTC_8x6_UNORM_BLOCK", "ASTC_8x6_UNORM_BLOCK"),

	/**
	 * The '<em><b>ASTC 8x6 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_8X6_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_8X6_SRGB_BLOCK(170, "ASTC_8x6_SRGB_BLOCK", "ASTC_8x6_SRGB_BLOCK"),

	/**
	 * The '<em><b>ASTC 8x8 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_8X8_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_8X8_UNORM_BLOCK(171, "ASTC_8x8_UNORM_BLOCK", "ASTC_8x8_UNORM_BLOCK"),

	/**
	 * The '<em><b>ASTC 8x8 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_8X8_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_8X8_SRGB_BLOCK(172, "ASTC_8x8_SRGB_BLOCK", "ASTC_8x8_SRGB_BLOCK"),

	/**
	 * The '<em><b>ASTC 10x5 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_10X5_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_10X5_UNORM_BLOCK(173, "ASTC_10x5_UNORM_BLOCK", "ASTC_10x5_UNORM_BLOCK"),

	/**
	 * The '<em><b>ASTC 10x5 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_10X5_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_10X5_SRGB_BLOCK(174, "ASTC_10x5_SRGB_BLOCK", "ASTC_10x5_SRGB_BLOCK"),

	/**
	 * The '<em><b>ASTC 10x6 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_10X6_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_10X6_UNORM_BLOCK(175, "ASTC_10x6_UNORM_BLOCK", "ASTC_10x6_UNORM_BLOCK"),

	/**
	 * The '<em><b>ASTC 10x6 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_10X6_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_10X6_SRGB_BLOCK(176, "ASTC_10x6_SRGB_BLOCK", "ASTC_10x6_SRGB_BLOCK"),

	/**
	 * The '<em><b>ASTC 10x8 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_10X8_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_10X8_UNORM_BLOCK(177, "ASTC_10x8_UNORM_BLOCK", "ASTC_10x8_UNORM_BLOCK"),

	/**
	 * The '<em><b>ASTC 10x8 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_10X8_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_10X8_SRGB_BLOCK(178, "ASTC_10x8_SRGB_BLOCK", "ASTC_10x8_SRGB_BLOCK"),

	/**
	 * The '<em><b>ASTC 10x10 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_10X10_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_10X10_UNORM_BLOCK(179, "ASTC_10x10_UNORM_BLOCK", "ASTC_10x10_UNORM_BLOCK"),

	/**
	 * The '<em><b>ASTC 10x10 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_10X10_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_10X10_SRGB_BLOCK(180, "ASTC_10x10_SRGB_BLOCK", "ASTC_10x10_SRGB_BLOCK"),

	/**
	 * The '<em><b>ASTC 12x10 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_12X10_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_12X10_UNORM_BLOCK(181, "ASTC_12x10_UNORM_BLOCK", "ASTC_12x10_UNORM_BLOCK"),

	/**
	 * The '<em><b>ASTC 12x10 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_12X10_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_12X10_SRGB_BLOCK(182, "ASTC_12x10_SRGB_BLOCK", "ASTC_12x10_SRGB_BLOCK"),

	/**
	 * The '<em><b>ASTC 12x12 UNORM BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_12X12_UNORM_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_12X12_UNORM_BLOCK(183, "ASTC_12x12_UNORM_BLOCK", "ASTC_12x12_UNORM_BLOCK"),

	/**
	 * The '<em><b>ASTC 12x12 SRGB BLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_12X12_SRGB_BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ASTC_12X12_SRGB_BLOCK(184, "ASTC_12x12_SRGB_BLOCK", "ASTC_12x12_SRGB_BLOCK");

	/**
	 * The '<em><b>UNDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNDEFINED_VALUE = 0;

	/**
	 * The '<em><b>R4G4 UNORM PACK8</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R4G4_UNORM_PACK8
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R4G4_UNORM_PACK8_VALUE = 1;

	/**
	 * The '<em><b>R4G4B4A4 UNORM PACK16</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R4G4B4A4_UNORM_PACK16
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R4G4B4A4_UNORM_PACK16_VALUE = 2;

	/**
	 * The '<em><b>B4G4R4A4 UNORM PACK16</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B4G4R4A4_UNORM_PACK16
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B4G4R4A4_UNORM_PACK16_VALUE = 3;

	/**
	 * The '<em><b>R5G6B5 UNORM PACK16</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R5G6B5_UNORM_PACK16
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R5G6B5_UNORM_PACK16_VALUE = 4;

	/**
	 * The '<em><b>B5G6R5 UNORM PACK16</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B5G6R5_UNORM_PACK16
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B5G6R5_UNORM_PACK16_VALUE = 5;

	/**
	 * The '<em><b>R5G5B5A1 UNORM PACK16</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R5G5B5A1_UNORM_PACK16
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R5G5B5A1_UNORM_PACK16_VALUE = 6;

	/**
	 * The '<em><b>B5G5R5A1 UNORM PACK16</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B5G5R5A1_UNORM_PACK16
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B5G5R5A1_UNORM_PACK16_VALUE = 7;

	/**
	 * The '<em><b>A1R5G5B5 UNORM PACK16</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A1R5G5B5_UNORM_PACK16
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A1R5G5B5_UNORM_PACK16_VALUE = 8;

	/**
	 * The '<em><b>R8 UNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8_UNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8_UNORM_VALUE = 9;

	/**
	 * The '<em><b>R8 SNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8_SNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8_SNORM_VALUE = 10;

	/**
	 * The '<em><b>R8 USCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8_USCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8_USCALED_VALUE = 11;

	/**
	 * The '<em><b>R8 SSCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8_SSCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8_SSCALED_VALUE = 12;

	/**
	 * The '<em><b>R8 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8_UINT_VALUE = 13;

	/**
	 * The '<em><b>R8 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8_SINT_VALUE = 14;

	/**
	 * The '<em><b>R8 SRGB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8_SRGB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8_SRGB_VALUE = 15;

	/**
	 * The '<em><b>R8G8 UNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8_UNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8_UNORM_VALUE = 16;

	/**
	 * The '<em><b>R8G8 SNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8_SNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8_SNORM_VALUE = 17;

	/**
	 * The '<em><b>R8G8 USCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8_USCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8_USCALED_VALUE = 18;

	/**
	 * The '<em><b>R8G8 SSCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8_SSCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8_SSCALED_VALUE = 19;

	/**
	 * The '<em><b>R8G8 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8_UINT_VALUE = 20;

	/**
	 * The '<em><b>R8G8 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8_SINT_VALUE = 21;

	/**
	 * The '<em><b>R8G8 SRGB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8_SRGB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8_SRGB_VALUE = 22;

	/**
	 * The '<em><b>R8G8B8 UNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8_UNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8B8_UNORM_VALUE = 23;

	/**
	 * The '<em><b>R8G8B8 SNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8_SNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8B8_SNORM_VALUE = 24;

	/**
	 * The '<em><b>R8G8B8 USCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8_USCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8B8_USCALED_VALUE = 25;

	/**
	 * The '<em><b>R8G8B8 SSCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8_SSCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8B8_SSCALED_VALUE = 26;

	/**
	 * The '<em><b>R8G8B8 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8B8_UINT_VALUE = 27;

	/**
	 * The '<em><b>R8G8B8 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8B8_SINT_VALUE = 28;

	/**
	 * The '<em><b>R8G8B8 SRGB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8_SRGB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8B8_SRGB_VALUE = 29;

	/**
	 * The '<em><b>B8G8R8 UNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8_UNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B8G8R8_UNORM_VALUE = 30;

	/**
	 * The '<em><b>B8G8R8 SNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8_SNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B8G8R8_SNORM_VALUE = 31;

	/**
	 * The '<em><b>B8G8R8 USCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8_USCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B8G8R8_USCALED_VALUE = 32;

	/**
	 * The '<em><b>B8G8R8 SSCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8_SSCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B8G8R8_SSCALED_VALUE = 33;

	/**
	 * The '<em><b>B8G8R8 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B8G8R8_UINT_VALUE = 34;

	/**
	 * The '<em><b>B8G8R8 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B8G8R8_SINT_VALUE = 35;

	/**
	 * The '<em><b>B8G8R8 SRGB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8_SRGB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B8G8R8_SRGB_VALUE = 36;

	/**
	 * The '<em><b>R8G8B8A8 UNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8A8_UNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8B8A8_UNORM_VALUE = 37;

	/**
	 * The '<em><b>R8G8B8A8 SNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8A8_SNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8B8A8_SNORM_VALUE = 38;

	/**
	 * The '<em><b>R8G8B8A8 USCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8A8_USCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8B8A8_USCALED_VALUE = 39;

	/**
	 * The '<em><b>R8G8B8A8 SSCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8A8_SSCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8B8A8_SSCALED_VALUE = 40;

	/**
	 * The '<em><b>R8G8B8A8 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8A8_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8B8A8_UINT_VALUE = 41;

	/**
	 * The '<em><b>R8G8B8A8 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8A8_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8B8A8_SINT_VALUE = 42;

	/**
	 * The '<em><b>R8G8B8A8 SRGB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R8G8B8A8_SRGB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R8G8B8A8_SRGB_VALUE = 43;

	/**
	 * The '<em><b>B8G8R8A8 UNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8A8_UNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B8G8R8A8_UNORM_VALUE = 44;

	/**
	 * The '<em><b>B8G8R8A8 SNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8A8_SNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B8G8R8A8_SNORM_VALUE = 45;

	/**
	 * The '<em><b>B8G8R8A8 USCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8A8_USCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B8G8R8A8_USCALED_VALUE = 46;

	/**
	 * The '<em><b>B8G8R8A8 SSCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8A8_SSCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B8G8R8A8_SSCALED_VALUE = 47;

	/**
	 * The '<em><b>B8G8R8A8 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8A8_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B8G8R8A8_UINT_VALUE = 48;

	/**
	 * The '<em><b>B8G8R8A8 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8A8_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B8G8R8A8_SINT_VALUE = 49;

	/**
	 * The '<em><b>B8G8R8A8 SRGB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B8G8R8A8_SRGB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B8G8R8A8_SRGB_VALUE = 50;

	/**
	 * The '<em><b>A8B8G8R8 UNORM PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A8B8G8R8_UNORM_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A8B8G8R8_UNORM_PACK32_VALUE = 51;

	/**
	 * The '<em><b>A8B8G8R8 SNORM PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A8B8G8R8_SNORM_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A8B8G8R8_SNORM_PACK32_VALUE = 52;

	/**
	 * The '<em><b>A8B8G8R8 USCALED PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A8B8G8R8_USCALED_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A8B8G8R8_USCALED_PACK32_VALUE = 53;

	/**
	 * The '<em><b>A8B8G8R8 SSCALED PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A8B8G8R8_SSCALED_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A8B8G8R8_SSCALED_PACK32_VALUE = 54;

	/**
	 * The '<em><b>A8B8G8R8 UINT PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A8B8G8R8_UINT_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A8B8G8R8_UINT_PACK32_VALUE = 55;

	/**
	 * The '<em><b>A8B8G8R8 SINT PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A8B8G8R8_SINT_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A8B8G8R8_SINT_PACK32_VALUE = 56;

	/**
	 * The '<em><b>A8B8G8R8 SRGB PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A8B8G8R8_SRGB_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A8B8G8R8_SRGB_PACK32_VALUE = 57;

	/**
	 * The '<em><b>A2R10G10B10 UNORM PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2R10G10B10_UNORM_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A2R10G10B10_UNORM_PACK32_VALUE = 58;

	/**
	 * The '<em><b>A2R10G10B10 SNORM PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2R10G10B10_SNORM_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A2R10G10B10_SNORM_PACK32_VALUE = 59;

	/**
	 * The '<em><b>A2R10G10B10 USCALED PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2R10G10B10_USCALED_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A2R10G10B10_USCALED_PACK32_VALUE = 60;

	/**
	 * The '<em><b>A2R10G10B10 SSCALED PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2R10G10B10_SSCALED_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A2R10G10B10_SSCALED_PACK32_VALUE = 61;

	/**
	 * The '<em><b>A2R10G10B10 UINT PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2R10G10B10_UINT_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A2R10G10B10_UINT_PACK32_VALUE = 62;

	/**
	 * The '<em><b>A2R10G10B10 SINT PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2R10G10B10_SINT_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A2R10G10B10_SINT_PACK32_VALUE = 63;

	/**
	 * The '<em><b>A2B10G10R10 UNORM PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2B10G10R10_UNORM_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A2B10G10R10_UNORM_PACK32_VALUE = 64;

	/**
	 * The '<em><b>A2B10G10R10 SNORM PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2B10G10R10_SNORM_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A2B10G10R10_SNORM_PACK32_VALUE = 65;

	/**
	 * The '<em><b>A2B10G10R10 USCALED PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2B10G10R10_USCALED_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A2B10G10R10_USCALED_PACK32_VALUE = 66;

	/**
	 * The '<em><b>A2B10G10R10 SSCALED PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2B10G10R10_SSCALED_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A2B10G10R10_SSCALED_PACK32_VALUE = 67;

	/**
	 * The '<em><b>A2B10G10R10 UINT PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2B10G10R10_UINT_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A2B10G10R10_UINT_PACK32_VALUE = 68;

	/**
	 * The '<em><b>A2B10G10R10 SINT PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #A2B10G10R10_SINT_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int A2B10G10R10_SINT_PACK32_VALUE = 69;

	/**
	 * The '<em><b>R16 UNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16_UNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16_UNORM_VALUE = 70;

	/**
	 * The '<em><b>R16 SNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16_SNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16_SNORM_VALUE = 71;

	/**
	 * The '<em><b>R16 USCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16_USCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16_USCALED_VALUE = 72;

	/**
	 * The '<em><b>R16 SSCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16_SSCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16_SSCALED_VALUE = 73;

	/**
	 * The '<em><b>R16 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16_UINT_VALUE = 74;

	/**
	 * The '<em><b>R16 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16_SINT_VALUE = 75;

	/**
	 * The '<em><b>R16 SFLOAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16_SFLOAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16_SFLOAT_VALUE = 76;

	/**
	 * The '<em><b>R16G16 UNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16_UNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16_UNORM_VALUE = 77;

	/**
	 * The '<em><b>R16G16 SNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16_SNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16_SNORM_VALUE = 78;

	/**
	 * The '<em><b>R16G16 USCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16_USCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16_USCALED_VALUE = 79;

	/**
	 * The '<em><b>R16G16 SSCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16_SSCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16_SSCALED_VALUE = 80;

	/**
	 * The '<em><b>R16G16 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16_UINT_VALUE = 81;

	/**
	 * The '<em><b>R16G16 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16_SINT_VALUE = 82;

	/**
	 * The '<em><b>R16G16 SFLOAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16_SFLOAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16_SFLOAT_VALUE = 83;

	/**
	 * The '<em><b>R16G16B16 UNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16_UNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16B16_UNORM_VALUE = 84;

	/**
	 * The '<em><b>R16G16B16 SNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16_SNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16B16_SNORM_VALUE = 85;

	/**
	 * The '<em><b>R16G16B16 USCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16_USCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16B16_USCALED_VALUE = 86;

	/**
	 * The '<em><b>R16G16B16 SSCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16_SSCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16B16_SSCALED_VALUE = 87;

	/**
	 * The '<em><b>R16G16B16 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16B16_UINT_VALUE = 88;

	/**
	 * The '<em><b>R16G16B16 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16B16_SINT_VALUE = 89;

	/**
	 * The '<em><b>R16G16B16 SFLOAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16_SFLOAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16B16_SFLOAT_VALUE = 90;

	/**
	 * The '<em><b>R16G16B16A16 UNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16A16_UNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16B16A16_UNORM_VALUE = 91;

	/**
	 * The '<em><b>R16G16B16A16 SNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16A16_SNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16B16A16_SNORM_VALUE = 92;

	/**
	 * The '<em><b>R16G16B16A16 USCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16A16_USCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16B16A16_USCALED_VALUE = 93;

	/**
	 * The '<em><b>R16G16B16A16 SSCALED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16A16_SSCALED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16B16A16_SSCALED_VALUE = 94;

	/**
	 * The '<em><b>R16G16B16A16 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16A16_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16B16A16_UINT_VALUE = 95;

	/**
	 * The '<em><b>R16G16B16A16 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16A16_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16B16A16_SINT_VALUE = 96;

	/**
	 * The '<em><b>R16G16B16A16 SFLOAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R16G16B16A16_SFLOAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R16G16B16A16_SFLOAT_VALUE = 97;

	/**
	 * The '<em><b>R32 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R32_UINT_VALUE = 98;

	/**
	 * The '<em><b>R32 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R32_SINT_VALUE = 99;

	/**
	 * The '<em><b>R32 SFLOAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32_SFLOAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R32_SFLOAT_VALUE = 100;

	/**
	 * The '<em><b>R32G32 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R32G32_UINT_VALUE = 101;

	/**
	 * The '<em><b>R32G32 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R32G32_SINT_VALUE = 102;

	/**
	 * The '<em><b>R32G32 SFLOAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32_SFLOAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R32G32_SFLOAT_VALUE = 103;

	/**
	 * The '<em><b>R32G32B32 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32B32_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R32G32B32_UINT_VALUE = 104;

	/**
	 * The '<em><b>R32G32B32 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32B32_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R32G32B32_SINT_VALUE = 105;

	/**
	 * The '<em><b>R32G32B32 SFLOAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32B32_SFLOAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R32G32B32_SFLOAT_VALUE = 106;

	/**
	 * The '<em><b>R32G32B32A32 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32B32A32_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R32G32B32A32_UINT_VALUE = 107;

	/**
	 * The '<em><b>R32G32B32A32 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32B32A32_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R32G32B32A32_SINT_VALUE = 108;

	/**
	 * The '<em><b>R32G32B32A32 SFLOAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R32G32B32A32_SFLOAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R32G32B32A32_SFLOAT_VALUE = 109;

	/**
	 * The '<em><b>R64 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R64_UINT_VALUE = 110;

	/**
	 * The '<em><b>R64 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R64_SINT_VALUE = 111;

	/**
	 * The '<em><b>R64 SFLOAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64_SFLOAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R64_SFLOAT_VALUE = 112;

	/**
	 * The '<em><b>R64G64 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R64G64_UINT_VALUE = 113;

	/**
	 * The '<em><b>R64G64 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R64G64_SINT_VALUE = 114;

	/**
	 * The '<em><b>R64G64 SFLOAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64_SFLOAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R64G64_SFLOAT_VALUE = 115;

	/**
	 * The '<em><b>R64G64B64 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64B64_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R64G64B64_UINT_VALUE = 116;

	/**
	 * The '<em><b>R64G64B64 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64B64_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R64G64B64_SINT_VALUE = 117;

	/**
	 * The '<em><b>R64G64B64 SFLOAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64B64_SFLOAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R64G64B64_SFLOAT_VALUE = 118;

	/**
	 * The '<em><b>R64G64B64A64 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64B64A64_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R64G64B64A64_UINT_VALUE = 119;

	/**
	 * The '<em><b>R64G64B64A64 SINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64B64A64_SINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R64G64B64A64_SINT_VALUE = 120;

	/**
	 * The '<em><b>R64G64B64A64 SFLOAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #R64G64B64A64_SFLOAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int R64G64B64A64_SFLOAT_VALUE = 121;

	/**
	 * The '<em><b>B10G11R11 UFLOAT PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #B10G11R11_UFLOAT_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int B10G11R11_UFLOAT_PACK32_VALUE = 122;

	/**
	 * The '<em><b>E5B9G9R9 UFLOAT PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #E5B9G9R9_UFLOAT_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int E5B9G9R9_UFLOAT_PACK32_VALUE = 123;

	/**
	 * The '<em><b>D16 UNORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #D16_UNORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int D16_UNORM_VALUE = 124;

	/**
	 * The '<em><b>X8 D24 UNORM PACK32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #X8_D24_UNORM_PACK32
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int X8_D24_UNORM_PACK32_VALUE = 125;

	/**
	 * The '<em><b>D32 SFLOAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #D32_SFLOAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int D32_SFLOAT_VALUE = 126;

	/**
	 * The '<em><b>S8 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #S8_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int S8_UINT_VALUE = 127;

	/**
	 * The '<em><b>D16 UNORM S8 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #D16_UNORM_S8_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int D16_UNORM_S8_UINT_VALUE = 128;

	/**
	 * The '<em><b>D24 UNORM S8 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #D24_UNORM_S8_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int D24_UNORM_S8_UINT_VALUE = 129;

	/**
	 * The '<em><b>D32 SFLOAT S8 UINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #D32_SFLOAT_S8_UINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int D32_SFLOAT_S8_UINT_VALUE = 130;

	/**
	 * The '<em><b>BC1 RGB UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC1_RGB_UNORM_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BC1_RGB_UNORM_BLOCK_VALUE = 131;

	/**
	 * The '<em><b>BC1 RGB SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC1_RGB_SRGB_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BC1_RGB_SRGB_BLOCK_VALUE = 132;

	/**
	 * The '<em><b>BC1 RGBA UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC1_RGBA_UNORM_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BC1_RGBA_UNORM_BLOCK_VALUE = 133;

	/**
	 * The '<em><b>BC1 RGBA SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC1_RGBA_SRGB_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BC1_RGBA_SRGB_BLOCK_VALUE = 134;

	/**
	 * The '<em><b>BC2 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC2_UNORM_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BC2_UNORM_BLOCK_VALUE = 135;

	/**
	 * The '<em><b>BC2 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC2_SRGB_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BC2_SRGB_BLOCK_VALUE = 136;

	/**
	 * The '<em><b>BC3 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC3_UNORM_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BC3_UNORM_BLOCK_VALUE = 137;

	/**
	 * The '<em><b>BC3 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC3_SRGB_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BC3_SRGB_BLOCK_VALUE = 138;

	/**
	 * The '<em><b>BC4 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC4_UNORM_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BC4_UNORM_BLOCK_VALUE = 139;

	/**
	 * The '<em><b>BC4 SNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC4_SNORM_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BC4_SNORM_BLOCK_VALUE = 140;

	/**
	 * The '<em><b>BC5 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC5_UNORM_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BC5_UNORM_BLOCK_VALUE = 141;

	/**
	 * The '<em><b>BC5 SNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC5_SNORM_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BC5_SNORM_BLOCK_VALUE = 142;

	/**
	 * The '<em><b>BC6H UFLOAT BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC6H_UFLOAT_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BC6H_UFLOAT_BLOCK_VALUE = 143;

	/**
	 * The '<em><b>BC6H SFLOAT BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC6H_SFLOAT_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BC6H_SFLOAT_BLOCK_VALUE = 144;

	/**
	 * The '<em><b>BC7 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC7_UNORM_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BC7_UNORM_BLOCK_VALUE = 145;

	/**
	 * The '<em><b>BC7 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BC7_SRGB_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BC7_SRGB_BLOCK_VALUE = 146;

	/**
	 * The '<em><b>ETC2 R8G8B8 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETC2_R8G8B8_UNORM_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ETC2_R8G8B8_UNORM_BLOCK_VALUE = 147;

	/**
	 * The '<em><b>ETC2 R8G8B8 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETC2_R8G8B8_SRGB_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ETC2_R8G8B8_SRGB_BLOCK_VALUE = 148;

	/**
	 * The '<em><b>ETC2 R8G8B8A1 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETC2_R8G8B8A1_UNORM_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ETC2_R8G8B8A1_UNORM_BLOCK_VALUE = 149;

	/**
	 * The '<em><b>ETC2 R8G8B8A1 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETC2_R8G8B8A1_SRGB_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ETC2_R8G8B8A1_SRGB_BLOCK_VALUE = 150;

	/**
	 * The '<em><b>ETC2 R8G8B8A8 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETC2_R8G8B8A8_UNORM_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ETC2_R8G8B8A8_UNORM_BLOCK_VALUE = 151;

	/**
	 * The '<em><b>ETC2 R8G8B8A8 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETC2_R8G8B8A8_SRGB_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ETC2_R8G8B8A8_SRGB_BLOCK_VALUE = 152;

	/**
	 * The '<em><b>EAC R11 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EAC_R11_UNORM_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EAC_R11_UNORM_BLOCK_VALUE = 153;

	/**
	 * The '<em><b>EAC R11 SNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EAC_R11_SNORM_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EAC_R11_SNORM_BLOCK_VALUE = 154;

	/**
	 * The '<em><b>EAC R11G11 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EAC_R11G11_UNORM_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EAC_R11G11_UNORM_BLOCK_VALUE = 155;

	/**
	 * The '<em><b>EAC R11G11 SNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EAC_R11G11_SNORM_BLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EAC_R11G11_SNORM_BLOCK_VALUE = 156;

	/**
	 * The '<em><b>ASTC 4x4 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_4X4_UNORM_BLOCK
	 * @model name="ASTC_4x4_UNORM_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_4X4_UNORM_BLOCK_VALUE = 157;

	/**
	 * The '<em><b>ASTC 4x4 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_4X4_SRGB_BLOCK
	 * @model name="ASTC_4x4_SRGB_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_4X4_SRGB_BLOCK_VALUE = 158;

	/**
	 * The '<em><b>ASTC 5x4 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_5X4_UNORM_BLOCK
	 * @model name="ASTC_5x4_UNORM_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_5X4_UNORM_BLOCK_VALUE = 159;

	/**
	 * The '<em><b>ASTC 5x4 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_5X4_SRGB_BLOCK
	 * @model name="ASTC_5x4_SRGB_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_5X4_SRGB_BLOCK_VALUE = 160;

	/**
	 * The '<em><b>ASTC 5x5 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_5X5_UNORM_BLOCK
	 * @model name="ASTC_5x5_UNORM_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_5X5_UNORM_BLOCK_VALUE = 161;

	/**
	 * The '<em><b>ASTC 5x5 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_5X5_SRGB_BLOCK
	 * @model name="ASTC_5x5_SRGB_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_5X5_SRGB_BLOCK_VALUE = 162;

	/**
	 * The '<em><b>ASTC 6x5 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_6X5_UNORM_BLOCK
	 * @model name="ASTC_6x5_UNORM_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_6X5_UNORM_BLOCK_VALUE = 163;

	/**
	 * The '<em><b>ASTC 6x5 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_6X5_SRGB_BLOCK
	 * @model name="ASTC_6x5_SRGB_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_6X5_SRGB_BLOCK_VALUE = 164;

	/**
	 * The '<em><b>ASTC 6x6 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_6X6_UNORM_BLOCK
	 * @model name="ASTC_6x6_UNORM_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_6X6_UNORM_BLOCK_VALUE = 165;

	/**
	 * The '<em><b>ASTC 6x6 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_6X6_SRGB_BLOCK
	 * @model name="ASTC_6x6_SRGB_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_6X6_SRGB_BLOCK_VALUE = 166;

	/**
	 * The '<em><b>ASTC 8x5 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_8X5_UNORM_BLOCK
	 * @model name="ASTC_8x5_UNORM_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_8X5_UNORM_BLOCK_VALUE = 167;

	/**
	 * The '<em><b>ASTC 8x5 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_8X5_SRGB_BLOCK
	 * @model name="ASTC_8x5_SRGB_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_8X5_SRGB_BLOCK_VALUE = 168;

	/**
	 * The '<em><b>ASTC 8x6 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_8X6_UNORM_BLOCK
	 * @model name="ASTC_8x6_UNORM_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_8X6_UNORM_BLOCK_VALUE = 169;

	/**
	 * The '<em><b>ASTC 8x6 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_8X6_SRGB_BLOCK
	 * @model name="ASTC_8x6_SRGB_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_8X6_SRGB_BLOCK_VALUE = 170;

	/**
	 * The '<em><b>ASTC 8x8 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_8X8_UNORM_BLOCK
	 * @model name="ASTC_8x8_UNORM_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_8X8_UNORM_BLOCK_VALUE = 171;

	/**
	 * The '<em><b>ASTC 8x8 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_8X8_SRGB_BLOCK
	 * @model name="ASTC_8x8_SRGB_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_8X8_SRGB_BLOCK_VALUE = 172;

	/**
	 * The '<em><b>ASTC 10x5 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_10X5_UNORM_BLOCK
	 * @model name="ASTC_10x5_UNORM_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_10X5_UNORM_BLOCK_VALUE = 173;

	/**
	 * The '<em><b>ASTC 10x5 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_10X5_SRGB_BLOCK
	 * @model name="ASTC_10x5_SRGB_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_10X5_SRGB_BLOCK_VALUE = 174;

	/**
	 * The '<em><b>ASTC 10x6 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_10X6_UNORM_BLOCK
	 * @model name="ASTC_10x6_UNORM_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_10X6_UNORM_BLOCK_VALUE = 175;

	/**
	 * The '<em><b>ASTC 10x6 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_10X6_SRGB_BLOCK
	 * @model name="ASTC_10x6_SRGB_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_10X6_SRGB_BLOCK_VALUE = 176;

	/**
	 * The '<em><b>ASTC 10x8 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_10X8_UNORM_BLOCK
	 * @model name="ASTC_10x8_UNORM_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_10X8_UNORM_BLOCK_VALUE = 177;

	/**
	 * The '<em><b>ASTC 10x8 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_10X8_SRGB_BLOCK
	 * @model name="ASTC_10x8_SRGB_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_10X8_SRGB_BLOCK_VALUE = 178;

	/**
	 * The '<em><b>ASTC 10x10 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_10X10_UNORM_BLOCK
	 * @model name="ASTC_10x10_UNORM_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_10X10_UNORM_BLOCK_VALUE = 179;

	/**
	 * The '<em><b>ASTC 10x10 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_10X10_SRGB_BLOCK
	 * @model name="ASTC_10x10_SRGB_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_10X10_SRGB_BLOCK_VALUE = 180;

	/**
	 * The '<em><b>ASTC 12x10 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_12X10_UNORM_BLOCK
	 * @model name="ASTC_12x10_UNORM_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_12X10_UNORM_BLOCK_VALUE = 181;

	/**
	 * The '<em><b>ASTC 12x10 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_12X10_SRGB_BLOCK
	 * @model name="ASTC_12x10_SRGB_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_12X10_SRGB_BLOCK_VALUE = 182;

	/**
	 * The '<em><b>ASTC 12x12 UNORM BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_12X12_UNORM_BLOCK
	 * @model name="ASTC_12x12_UNORM_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_12X12_UNORM_BLOCK_VALUE = 183;

	/**
	 * The '<em><b>ASTC 12x12 SRGB BLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASTC_12X12_SRGB_BLOCK
	 * @model name="ASTC_12x12_SRGB_BLOCK"
	 * @generated
	 * @ordered
	 */
	public static final int ASTC_12X12_SRGB_BLOCK_VALUE = 184;

	/**
	 * An array of all the '<em><b>EFormat</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EFormat[] VALUES_ARRAY = new EFormat[]
		{
			UNDEFINED,
			R4G4_UNORM_PACK8,
			R4G4B4A4_UNORM_PACK16,
			B4G4R4A4_UNORM_PACK16,
			R5G6B5_UNORM_PACK16,
			B5G6R5_UNORM_PACK16,
			R5G5B5A1_UNORM_PACK16,
			B5G5R5A1_UNORM_PACK16,
			A1R5G5B5_UNORM_PACK16,
			R8_UNORM,
			R8_SNORM,
			R8_USCALED,
			R8_SSCALED,
			R8_UINT,
			R8_SINT,
			R8_SRGB,
			R8G8_UNORM,
			R8G8_SNORM,
			R8G8_USCALED,
			R8G8_SSCALED,
			R8G8_UINT,
			R8G8_SINT,
			R8G8_SRGB,
			R8G8B8_UNORM,
			R8G8B8_SNORM,
			R8G8B8_USCALED,
			R8G8B8_SSCALED,
			R8G8B8_UINT,
			R8G8B8_SINT,
			R8G8B8_SRGB,
			B8G8R8_UNORM,
			B8G8R8_SNORM,
			B8G8R8_USCALED,
			B8G8R8_SSCALED,
			B8G8R8_UINT,
			B8G8R8_SINT,
			B8G8R8_SRGB,
			R8G8B8A8_UNORM,
			R8G8B8A8_SNORM,
			R8G8B8A8_USCALED,
			R8G8B8A8_SSCALED,
			R8G8B8A8_UINT,
			R8G8B8A8_SINT,
			R8G8B8A8_SRGB,
			B8G8R8A8_UNORM,
			B8G8R8A8_SNORM,
			B8G8R8A8_USCALED,
			B8G8R8A8_SSCALED,
			B8G8R8A8_UINT,
			B8G8R8A8_SINT,
			B8G8R8A8_SRGB,
			A8B8G8R8_UNORM_PACK32,
			A8B8G8R8_SNORM_PACK32,
			A8B8G8R8_USCALED_PACK32,
			A8B8G8R8_SSCALED_PACK32,
			A8B8G8R8_UINT_PACK32,
			A8B8G8R8_SINT_PACK32,
			A8B8G8R8_SRGB_PACK32,
			A2R10G10B10_UNORM_PACK32,
			A2R10G10B10_SNORM_PACK32,
			A2R10G10B10_USCALED_PACK32,
			A2R10G10B10_SSCALED_PACK32,
			A2R10G10B10_UINT_PACK32,
			A2R10G10B10_SINT_PACK32,
			A2B10G10R10_UNORM_PACK32,
			A2B10G10R10_SNORM_PACK32,
			A2B10G10R10_USCALED_PACK32,
			A2B10G10R10_SSCALED_PACK32,
			A2B10G10R10_UINT_PACK32,
			A2B10G10R10_SINT_PACK32,
			R16_UNORM,
			R16_SNORM,
			R16_USCALED,
			R16_SSCALED,
			R16_UINT,
			R16_SINT,
			R16_SFLOAT,
			R16G16_UNORM,
			R16G16_SNORM,
			R16G16_USCALED,
			R16G16_SSCALED,
			R16G16_UINT,
			R16G16_SINT,
			R16G16_SFLOAT,
			R16G16B16_UNORM,
			R16G16B16_SNORM,
			R16G16B16_USCALED,
			R16G16B16_SSCALED,
			R16G16B16_UINT,
			R16G16B16_SINT,
			R16G16B16_SFLOAT,
			R16G16B16A16_UNORM,
			R16G16B16A16_SNORM,
			R16G16B16A16_USCALED,
			R16G16B16A16_SSCALED,
			R16G16B16A16_UINT,
			R16G16B16A16_SINT,
			R16G16B16A16_SFLOAT,
			R32_UINT,
			R32_SINT,
			R32_SFLOAT,
			R32G32_UINT,
			R32G32_SINT,
			R32G32_SFLOAT,
			R32G32B32_UINT,
			R32G32B32_SINT,
			R32G32B32_SFLOAT,
			R32G32B32A32_UINT,
			R32G32B32A32_SINT,
			R32G32B32A32_SFLOAT,
			R64_UINT,
			R64_SINT,
			R64_SFLOAT,
			R64G64_UINT,
			R64G64_SINT,
			R64G64_SFLOAT,
			R64G64B64_UINT,
			R64G64B64_SINT,
			R64G64B64_SFLOAT,
			R64G64B64A64_UINT,
			R64G64B64A64_SINT,
			R64G64B64A64_SFLOAT,
			B10G11R11_UFLOAT_PACK32,
			E5B9G9R9_UFLOAT_PACK32,
			D16_UNORM,
			X8_D24_UNORM_PACK32,
			D32_SFLOAT,
			S8_UINT,
			D16_UNORM_S8_UINT,
			D24_UNORM_S8_UINT,
			D32_SFLOAT_S8_UINT,
			BC1_RGB_UNORM_BLOCK,
			BC1_RGB_SRGB_BLOCK,
			BC1_RGBA_UNORM_BLOCK,
			BC1_RGBA_SRGB_BLOCK,
			BC2_UNORM_BLOCK,
			BC2_SRGB_BLOCK,
			BC3_UNORM_BLOCK,
			BC3_SRGB_BLOCK,
			BC4_UNORM_BLOCK,
			BC4_SNORM_BLOCK,
			BC5_UNORM_BLOCK,
			BC5_SNORM_BLOCK,
			BC6H_UFLOAT_BLOCK,
			BC6H_SFLOAT_BLOCK,
			BC7_UNORM_BLOCK,
			BC7_SRGB_BLOCK,
			ETC2_R8G8B8_UNORM_BLOCK,
			ETC2_R8G8B8_SRGB_BLOCK,
			ETC2_R8G8B8A1_UNORM_BLOCK,
			ETC2_R8G8B8A1_SRGB_BLOCK,
			ETC2_R8G8B8A8_UNORM_BLOCK,
			ETC2_R8G8B8A8_SRGB_BLOCK,
			EAC_R11_UNORM_BLOCK,
			EAC_R11_SNORM_BLOCK,
			EAC_R11G11_UNORM_BLOCK,
			EAC_R11G11_SNORM_BLOCK,
			ASTC_4X4_UNORM_BLOCK,
			ASTC_4X4_SRGB_BLOCK,
			ASTC_5X4_UNORM_BLOCK,
			ASTC_5X4_SRGB_BLOCK,
			ASTC_5X5_UNORM_BLOCK,
			ASTC_5X5_SRGB_BLOCK,
			ASTC_6X5_UNORM_BLOCK,
			ASTC_6X5_SRGB_BLOCK,
			ASTC_6X6_UNORM_BLOCK,
			ASTC_6X6_SRGB_BLOCK,
			ASTC_8X5_UNORM_BLOCK,
			ASTC_8X5_SRGB_BLOCK,
			ASTC_8X6_UNORM_BLOCK,
			ASTC_8X6_SRGB_BLOCK,
			ASTC_8X8_UNORM_BLOCK,
			ASTC_8X8_SRGB_BLOCK,
			ASTC_10X5_UNORM_BLOCK,
			ASTC_10X5_SRGB_BLOCK,
			ASTC_10X6_UNORM_BLOCK,
			ASTC_10X6_SRGB_BLOCK,
			ASTC_10X8_UNORM_BLOCK,
			ASTC_10X8_SRGB_BLOCK,
			ASTC_10X10_UNORM_BLOCK,
			ASTC_10X10_SRGB_BLOCK,
			ASTC_12X10_UNORM_BLOCK,
			ASTC_12X10_SRGB_BLOCK,
			ASTC_12X12_UNORM_BLOCK,
			ASTC_12X12_SRGB_BLOCK,
		};

	/**
	 * A public read-only list of all the '<em><b>EFormat</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EFormat> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EFormat</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EFormat get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EFormat result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EFormat</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EFormat getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			EFormat result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EFormat</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EFormat get(int value)
	{
		switch (value)
		{
			case UNDEFINED_VALUE: return UNDEFINED;
			case R4G4_UNORM_PACK8_VALUE: return R4G4_UNORM_PACK8;
			case R4G4B4A4_UNORM_PACK16_VALUE: return R4G4B4A4_UNORM_PACK16;
			case B4G4R4A4_UNORM_PACK16_VALUE: return B4G4R4A4_UNORM_PACK16;
			case R5G6B5_UNORM_PACK16_VALUE: return R5G6B5_UNORM_PACK16;
			case B5G6R5_UNORM_PACK16_VALUE: return B5G6R5_UNORM_PACK16;
			case R5G5B5A1_UNORM_PACK16_VALUE: return R5G5B5A1_UNORM_PACK16;
			case B5G5R5A1_UNORM_PACK16_VALUE: return B5G5R5A1_UNORM_PACK16;
			case A1R5G5B5_UNORM_PACK16_VALUE: return A1R5G5B5_UNORM_PACK16;
			case R8_UNORM_VALUE: return R8_UNORM;
			case R8_SNORM_VALUE: return R8_SNORM;
			case R8_USCALED_VALUE: return R8_USCALED;
			case R8_SSCALED_VALUE: return R8_SSCALED;
			case R8_UINT_VALUE: return R8_UINT;
			case R8_SINT_VALUE: return R8_SINT;
			case R8_SRGB_VALUE: return R8_SRGB;
			case R8G8_UNORM_VALUE: return R8G8_UNORM;
			case R8G8_SNORM_VALUE: return R8G8_SNORM;
			case R8G8_USCALED_VALUE: return R8G8_USCALED;
			case R8G8_SSCALED_VALUE: return R8G8_SSCALED;
			case R8G8_UINT_VALUE: return R8G8_UINT;
			case R8G8_SINT_VALUE: return R8G8_SINT;
			case R8G8_SRGB_VALUE: return R8G8_SRGB;
			case R8G8B8_UNORM_VALUE: return R8G8B8_UNORM;
			case R8G8B8_SNORM_VALUE: return R8G8B8_SNORM;
			case R8G8B8_USCALED_VALUE: return R8G8B8_USCALED;
			case R8G8B8_SSCALED_VALUE: return R8G8B8_SSCALED;
			case R8G8B8_UINT_VALUE: return R8G8B8_UINT;
			case R8G8B8_SINT_VALUE: return R8G8B8_SINT;
			case R8G8B8_SRGB_VALUE: return R8G8B8_SRGB;
			case B8G8R8_UNORM_VALUE: return B8G8R8_UNORM;
			case B8G8R8_SNORM_VALUE: return B8G8R8_SNORM;
			case B8G8R8_USCALED_VALUE: return B8G8R8_USCALED;
			case B8G8R8_SSCALED_VALUE: return B8G8R8_SSCALED;
			case B8G8R8_UINT_VALUE: return B8G8R8_UINT;
			case B8G8R8_SINT_VALUE: return B8G8R8_SINT;
			case B8G8R8_SRGB_VALUE: return B8G8R8_SRGB;
			case R8G8B8A8_UNORM_VALUE: return R8G8B8A8_UNORM;
			case R8G8B8A8_SNORM_VALUE: return R8G8B8A8_SNORM;
			case R8G8B8A8_USCALED_VALUE: return R8G8B8A8_USCALED;
			case R8G8B8A8_SSCALED_VALUE: return R8G8B8A8_SSCALED;
			case R8G8B8A8_UINT_VALUE: return R8G8B8A8_UINT;
			case R8G8B8A8_SINT_VALUE: return R8G8B8A8_SINT;
			case R8G8B8A8_SRGB_VALUE: return R8G8B8A8_SRGB;
			case B8G8R8A8_UNORM_VALUE: return B8G8R8A8_UNORM;
			case B8G8R8A8_SNORM_VALUE: return B8G8R8A8_SNORM;
			case B8G8R8A8_USCALED_VALUE: return B8G8R8A8_USCALED;
			case B8G8R8A8_SSCALED_VALUE: return B8G8R8A8_SSCALED;
			case B8G8R8A8_UINT_VALUE: return B8G8R8A8_UINT;
			case B8G8R8A8_SINT_VALUE: return B8G8R8A8_SINT;
			case B8G8R8A8_SRGB_VALUE: return B8G8R8A8_SRGB;
			case A8B8G8R8_UNORM_PACK32_VALUE: return A8B8G8R8_UNORM_PACK32;
			case A8B8G8R8_SNORM_PACK32_VALUE: return A8B8G8R8_SNORM_PACK32;
			case A8B8G8R8_USCALED_PACK32_VALUE: return A8B8G8R8_USCALED_PACK32;
			case A8B8G8R8_SSCALED_PACK32_VALUE: return A8B8G8R8_SSCALED_PACK32;
			case A8B8G8R8_UINT_PACK32_VALUE: return A8B8G8R8_UINT_PACK32;
			case A8B8G8R8_SINT_PACK32_VALUE: return A8B8G8R8_SINT_PACK32;
			case A8B8G8R8_SRGB_PACK32_VALUE: return A8B8G8R8_SRGB_PACK32;
			case A2R10G10B10_UNORM_PACK32_VALUE: return A2R10G10B10_UNORM_PACK32;
			case A2R10G10B10_SNORM_PACK32_VALUE: return A2R10G10B10_SNORM_PACK32;
			case A2R10G10B10_USCALED_PACK32_VALUE: return A2R10G10B10_USCALED_PACK32;
			case A2R10G10B10_SSCALED_PACK32_VALUE: return A2R10G10B10_SSCALED_PACK32;
			case A2R10G10B10_UINT_PACK32_VALUE: return A2R10G10B10_UINT_PACK32;
			case A2R10G10B10_SINT_PACK32_VALUE: return A2R10G10B10_SINT_PACK32;
			case A2B10G10R10_UNORM_PACK32_VALUE: return A2B10G10R10_UNORM_PACK32;
			case A2B10G10R10_SNORM_PACK32_VALUE: return A2B10G10R10_SNORM_PACK32;
			case A2B10G10R10_USCALED_PACK32_VALUE: return A2B10G10R10_USCALED_PACK32;
			case A2B10G10R10_SSCALED_PACK32_VALUE: return A2B10G10R10_SSCALED_PACK32;
			case A2B10G10R10_UINT_PACK32_VALUE: return A2B10G10R10_UINT_PACK32;
			case A2B10G10R10_SINT_PACK32_VALUE: return A2B10G10R10_SINT_PACK32;
			case R16_UNORM_VALUE: return R16_UNORM;
			case R16_SNORM_VALUE: return R16_SNORM;
			case R16_USCALED_VALUE: return R16_USCALED;
			case R16_SSCALED_VALUE: return R16_SSCALED;
			case R16_UINT_VALUE: return R16_UINT;
			case R16_SINT_VALUE: return R16_SINT;
			case R16_SFLOAT_VALUE: return R16_SFLOAT;
			case R16G16_UNORM_VALUE: return R16G16_UNORM;
			case R16G16_SNORM_VALUE: return R16G16_SNORM;
			case R16G16_USCALED_VALUE: return R16G16_USCALED;
			case R16G16_SSCALED_VALUE: return R16G16_SSCALED;
			case R16G16_UINT_VALUE: return R16G16_UINT;
			case R16G16_SINT_VALUE: return R16G16_SINT;
			case R16G16_SFLOAT_VALUE: return R16G16_SFLOAT;
			case R16G16B16_UNORM_VALUE: return R16G16B16_UNORM;
			case R16G16B16_SNORM_VALUE: return R16G16B16_SNORM;
			case R16G16B16_USCALED_VALUE: return R16G16B16_USCALED;
			case R16G16B16_SSCALED_VALUE: return R16G16B16_SSCALED;
			case R16G16B16_UINT_VALUE: return R16G16B16_UINT;
			case R16G16B16_SINT_VALUE: return R16G16B16_SINT;
			case R16G16B16_SFLOAT_VALUE: return R16G16B16_SFLOAT;
			case R16G16B16A16_UNORM_VALUE: return R16G16B16A16_UNORM;
			case R16G16B16A16_SNORM_VALUE: return R16G16B16A16_SNORM;
			case R16G16B16A16_USCALED_VALUE: return R16G16B16A16_USCALED;
			case R16G16B16A16_SSCALED_VALUE: return R16G16B16A16_SSCALED;
			case R16G16B16A16_UINT_VALUE: return R16G16B16A16_UINT;
			case R16G16B16A16_SINT_VALUE: return R16G16B16A16_SINT;
			case R16G16B16A16_SFLOAT_VALUE: return R16G16B16A16_SFLOAT;
			case R32_UINT_VALUE: return R32_UINT;
			case R32_SINT_VALUE: return R32_SINT;
			case R32_SFLOAT_VALUE: return R32_SFLOAT;
			case R32G32_UINT_VALUE: return R32G32_UINT;
			case R32G32_SINT_VALUE: return R32G32_SINT;
			case R32G32_SFLOAT_VALUE: return R32G32_SFLOAT;
			case R32G32B32_UINT_VALUE: return R32G32B32_UINT;
			case R32G32B32_SINT_VALUE: return R32G32B32_SINT;
			case R32G32B32_SFLOAT_VALUE: return R32G32B32_SFLOAT;
			case R32G32B32A32_UINT_VALUE: return R32G32B32A32_UINT;
			case R32G32B32A32_SINT_VALUE: return R32G32B32A32_SINT;
			case R32G32B32A32_SFLOAT_VALUE: return R32G32B32A32_SFLOAT;
			case R64_UINT_VALUE: return R64_UINT;
			case R64_SINT_VALUE: return R64_SINT;
			case R64_SFLOAT_VALUE: return R64_SFLOAT;
			case R64G64_UINT_VALUE: return R64G64_UINT;
			case R64G64_SINT_VALUE: return R64G64_SINT;
			case R64G64_SFLOAT_VALUE: return R64G64_SFLOAT;
			case R64G64B64_UINT_VALUE: return R64G64B64_UINT;
			case R64G64B64_SINT_VALUE: return R64G64B64_SINT;
			case R64G64B64_SFLOAT_VALUE: return R64G64B64_SFLOAT;
			case R64G64B64A64_UINT_VALUE: return R64G64B64A64_UINT;
			case R64G64B64A64_SINT_VALUE: return R64G64B64A64_SINT;
			case R64G64B64A64_SFLOAT_VALUE: return R64G64B64A64_SFLOAT;
			case B10G11R11_UFLOAT_PACK32_VALUE: return B10G11R11_UFLOAT_PACK32;
			case E5B9G9R9_UFLOAT_PACK32_VALUE: return E5B9G9R9_UFLOAT_PACK32;
			case D16_UNORM_VALUE: return D16_UNORM;
			case X8_D24_UNORM_PACK32_VALUE: return X8_D24_UNORM_PACK32;
			case D32_SFLOAT_VALUE: return D32_SFLOAT;
			case S8_UINT_VALUE: return S8_UINT;
			case D16_UNORM_S8_UINT_VALUE: return D16_UNORM_S8_UINT;
			case D24_UNORM_S8_UINT_VALUE: return D24_UNORM_S8_UINT;
			case D32_SFLOAT_S8_UINT_VALUE: return D32_SFLOAT_S8_UINT;
			case BC1_RGB_UNORM_BLOCK_VALUE: return BC1_RGB_UNORM_BLOCK;
			case BC1_RGB_SRGB_BLOCK_VALUE: return BC1_RGB_SRGB_BLOCK;
			case BC1_RGBA_UNORM_BLOCK_VALUE: return BC1_RGBA_UNORM_BLOCK;
			case BC1_RGBA_SRGB_BLOCK_VALUE: return BC1_RGBA_SRGB_BLOCK;
			case BC2_UNORM_BLOCK_VALUE: return BC2_UNORM_BLOCK;
			case BC2_SRGB_BLOCK_VALUE: return BC2_SRGB_BLOCK;
			case BC3_UNORM_BLOCK_VALUE: return BC3_UNORM_BLOCK;
			case BC3_SRGB_BLOCK_VALUE: return BC3_SRGB_BLOCK;
			case BC4_UNORM_BLOCK_VALUE: return BC4_UNORM_BLOCK;
			case BC4_SNORM_BLOCK_VALUE: return BC4_SNORM_BLOCK;
			case BC5_UNORM_BLOCK_VALUE: return BC5_UNORM_BLOCK;
			case BC5_SNORM_BLOCK_VALUE: return BC5_SNORM_BLOCK;
			case BC6H_UFLOAT_BLOCK_VALUE: return BC6H_UFLOAT_BLOCK;
			case BC6H_SFLOAT_BLOCK_VALUE: return BC6H_SFLOAT_BLOCK;
			case BC7_UNORM_BLOCK_VALUE: return BC7_UNORM_BLOCK;
			case BC7_SRGB_BLOCK_VALUE: return BC7_SRGB_BLOCK;
			case ETC2_R8G8B8_UNORM_BLOCK_VALUE: return ETC2_R8G8B8_UNORM_BLOCK;
			case ETC2_R8G8B8_SRGB_BLOCK_VALUE: return ETC2_R8G8B8_SRGB_BLOCK;
			case ETC2_R8G8B8A1_UNORM_BLOCK_VALUE: return ETC2_R8G8B8A1_UNORM_BLOCK;
			case ETC2_R8G8B8A1_SRGB_BLOCK_VALUE: return ETC2_R8G8B8A1_SRGB_BLOCK;
			case ETC2_R8G8B8A8_UNORM_BLOCK_VALUE: return ETC2_R8G8B8A8_UNORM_BLOCK;
			case ETC2_R8G8B8A8_SRGB_BLOCK_VALUE: return ETC2_R8G8B8A8_SRGB_BLOCK;
			case EAC_R11_UNORM_BLOCK_VALUE: return EAC_R11_UNORM_BLOCK;
			case EAC_R11_SNORM_BLOCK_VALUE: return EAC_R11_SNORM_BLOCK;
			case EAC_R11G11_UNORM_BLOCK_VALUE: return EAC_R11G11_UNORM_BLOCK;
			case EAC_R11G11_SNORM_BLOCK_VALUE: return EAC_R11G11_SNORM_BLOCK;
			case ASTC_4X4_UNORM_BLOCK_VALUE: return ASTC_4X4_UNORM_BLOCK;
			case ASTC_4X4_SRGB_BLOCK_VALUE: return ASTC_4X4_SRGB_BLOCK;
			case ASTC_5X4_UNORM_BLOCK_VALUE: return ASTC_5X4_UNORM_BLOCK;
			case ASTC_5X4_SRGB_BLOCK_VALUE: return ASTC_5X4_SRGB_BLOCK;
			case ASTC_5X5_UNORM_BLOCK_VALUE: return ASTC_5X5_UNORM_BLOCK;
			case ASTC_5X5_SRGB_BLOCK_VALUE: return ASTC_5X5_SRGB_BLOCK;
			case ASTC_6X5_UNORM_BLOCK_VALUE: return ASTC_6X5_UNORM_BLOCK;
			case ASTC_6X5_SRGB_BLOCK_VALUE: return ASTC_6X5_SRGB_BLOCK;
			case ASTC_6X6_UNORM_BLOCK_VALUE: return ASTC_6X6_UNORM_BLOCK;
			case ASTC_6X6_SRGB_BLOCK_VALUE: return ASTC_6X6_SRGB_BLOCK;
			case ASTC_8X5_UNORM_BLOCK_VALUE: return ASTC_8X5_UNORM_BLOCK;
			case ASTC_8X5_SRGB_BLOCK_VALUE: return ASTC_8X5_SRGB_BLOCK;
			case ASTC_8X6_UNORM_BLOCK_VALUE: return ASTC_8X6_UNORM_BLOCK;
			case ASTC_8X6_SRGB_BLOCK_VALUE: return ASTC_8X6_SRGB_BLOCK;
			case ASTC_8X8_UNORM_BLOCK_VALUE: return ASTC_8X8_UNORM_BLOCK;
			case ASTC_8X8_SRGB_BLOCK_VALUE: return ASTC_8X8_SRGB_BLOCK;
			case ASTC_10X5_UNORM_BLOCK_VALUE: return ASTC_10X5_UNORM_BLOCK;
			case ASTC_10X5_SRGB_BLOCK_VALUE: return ASTC_10X5_SRGB_BLOCK;
			case ASTC_10X6_UNORM_BLOCK_VALUE: return ASTC_10X6_UNORM_BLOCK;
			case ASTC_10X6_SRGB_BLOCK_VALUE: return ASTC_10X6_SRGB_BLOCK;
			case ASTC_10X8_UNORM_BLOCK_VALUE: return ASTC_10X8_UNORM_BLOCK;
			case ASTC_10X8_SRGB_BLOCK_VALUE: return ASTC_10X8_SRGB_BLOCK;
			case ASTC_10X10_UNORM_BLOCK_VALUE: return ASTC_10X10_UNORM_BLOCK;
			case ASTC_10X10_SRGB_BLOCK_VALUE: return ASTC_10X10_SRGB_BLOCK;
			case ASTC_12X10_UNORM_BLOCK_VALUE: return ASTC_12X10_UNORM_BLOCK;
			case ASTC_12X10_SRGB_BLOCK_VALUE: return ASTC_12X10_SRGB_BLOCK;
			case ASTC_12X12_UNORM_BLOCK_VALUE: return ASTC_12X12_UNORM_BLOCK;
			case ASTC_12X12_SRGB_BLOCK_VALUE: return ASTC_12X12_SRGB_BLOCK;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EFormat(int value, String name, String literal)
	{
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue()
	{
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral()
	{
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return literal;
	}

} //EFormat
