/**
 */
package org.sheepy.vulkan.model.enumeration;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.enumeration.EnumerationFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.vulkan.model/src/generated/java' editDirectory='/org.sheepy.vulkan.model.edit/src/generated/java' publicConstructors='true' complianceLevel='11.0' resource='XMI' extensibleProviderFactory='true' childCreationExtenders='true' basePackage='org.sheepy.vulkan.model'"
 * @generated
 */
public interface EnumerationPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "enumeration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.vulkan.model.enumeration";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "enumeration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnumerationPackage eINSTANCE = org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EImageLayout <em>EImage Layout</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEImageLayout()
	 * @generated
	 */
	int EIMAGE_LAYOUT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.ECullMode <em>ECull Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.ECullMode
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getECullMode()
	 * @generated
	 */
	int ECULL_MODE = 1;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EDescriptorType <em>EDescriptor Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EDescriptorType
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEDescriptorType()
	 * @generated
	 */
	int EDESCRIPTOR_TYPE = 2;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EFrontFace <em>EFront Face</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EFrontFace
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEFrontFace()
	 * @generated
	 */
	int EFRONT_FACE = 3;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EBorderColor <em>EBorder Color</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EBorderColor
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEBorderColor()
	 * @generated
	 */
	int EBORDER_COLOR = 4;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.ECommandStage <em>ECommand Stage</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.ECommandStage
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getECommandStage()
	 * @generated
	 */
	int ECOMMAND_STAGE = 5;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp <em>EAttachment Load Op</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEAttachmentLoadOp()
	 * @generated
	 */
	int EATTACHMENT_LOAD_OP = 6;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.ELogicOp <em>ELogic Op</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.ELogicOp
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getELogicOp()
	 * @generated
	 */
	int ELOGIC_OP = 7;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp <em>EAttachment Store Op</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEAttachmentStoreOp()
	 * @generated
	 */
	int EATTACHMENT_STORE_OP = 8;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EShaderStage <em>EShader Stage</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EShaderStage
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEShaderStage()
	 * @generated
	 */
	int ESHADER_STAGE = 9;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EFilter <em>EFilter</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EFilter
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEFilter()
	 * @generated
	 */
	int EFILTER = 10;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode <em>ESampler Mipmap Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getESamplerMipmapMode()
	 * @generated
	 */
	int ESAMPLER_MIPMAP_MODE = 11;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.ESamplerAddressMode <em>ESampler Address Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.ESamplerAddressMode
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getESamplerAddressMode()
	 * @generated
	 */
	int ESAMPLER_ADDRESS_MODE = 12;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EBlendFactor <em>EBlend Factor</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EBlendFactor
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEBlendFactor()
	 * @generated
	 */
	int EBLEND_FACTOR = 13;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EDynamicState <em>EDynamic State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EDynamicState
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEDynamicState()
	 * @generated
	 */
	int EDYNAMIC_STATE = 14;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EBlendOp <em>EBlend Op</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EBlendOp
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEBlendOp()
	 * @generated
	 */
	int EBLEND_OP = 15;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EPipelineStage <em>EPipeline Stage</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEPipelineStage()
	 * @generated
	 */
	int EPIPELINE_STAGE = 16;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EColorSpace <em>EColor Space</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EColorSpace
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEColorSpace()
	 * @generated
	 */
	int ECOLOR_SPACE = 17;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EFormat <em>EFormat</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EFormat
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEFormat()
	 * @generated
	 */
	int EFORMAT = 18;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EPresentMode <em>EPresent Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EPresentMode
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEPresentMode()
	 * @generated
	 */
	int EPRESENT_MODE = 19;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EPolygonMode <em>EPolygon Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EPolygonMode
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEPolygonMode()
	 * @generated
	 */
	int EPOLYGON_MODE = 20;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EImageUsage <em>EImage Usage</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EImageUsage
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEImageUsage()
	 * @generated
	 */
	int EIMAGE_USAGE = 21;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EBufferUsage <em>EBuffer Usage</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EBufferUsage
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEBufferUsage()
	 * @generated
	 */
	int EBUFFER_USAGE = 22;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.EMemoryProperty <em>EMemory Property</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.EMemoryProperty
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEMemoryProperty()
	 * @generated
	 */
	int EMEMORY_PROPERTY = 23;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.enumeration.ESampleCount <em>ESample Count</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.enumeration.ESampleCount
	 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getESampleCount()
	 * @generated
	 */
	int ESAMPLE_COUNT = 24;


	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EImageLayout <em>EImage Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EImage Layout</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @generated
	 */
	EEnum getEImageLayout();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.ECullMode <em>ECull Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ECull Mode</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.ECullMode
	 * @generated
	 */
	EEnum getECullMode();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EDescriptorType <em>EDescriptor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EDescriptor Type</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EDescriptorType
	 * @generated
	 */
	EEnum getEDescriptorType();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EFrontFace <em>EFront Face</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EFront Face</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EFrontFace
	 * @generated
	 */
	EEnum getEFrontFace();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EBorderColor <em>EBorder Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EBorder Color</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EBorderColor
	 * @generated
	 */
	EEnum getEBorderColor();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.ECommandStage <em>ECommand Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ECommand Stage</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.ECommandStage
	 * @generated
	 */
	EEnum getECommandStage();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp <em>EAttachment Load Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EAttachment Load Op</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp
	 * @generated
	 */
	EEnum getEAttachmentLoadOp();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.ELogicOp <em>ELogic Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ELogic Op</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.ELogicOp
	 * @generated
	 */
	EEnum getELogicOp();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp <em>EAttachment Store Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EAttachment Store Op</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp
	 * @generated
	 */
	EEnum getEAttachmentStoreOp();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EShaderStage <em>EShader Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EShader Stage</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EShaderStage
	 * @generated
	 */
	EEnum getEShaderStage();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EFilter <em>EFilter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EFilter</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EFilter
	 * @generated
	 */
	EEnum getEFilter();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode <em>ESampler Mipmap Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ESampler Mipmap Mode</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode
	 * @generated
	 */
	EEnum getESamplerMipmapMode();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.ESamplerAddressMode <em>ESampler Address Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ESampler Address Mode</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.ESamplerAddressMode
	 * @generated
	 */
	EEnum getESamplerAddressMode();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EBlendFactor <em>EBlend Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EBlend Factor</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EBlendFactor
	 * @generated
	 */
	EEnum getEBlendFactor();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EDynamicState <em>EDynamic State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EDynamic State</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EDynamicState
	 * @generated
	 */
	EEnum getEDynamicState();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EBlendOp <em>EBlend Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EBlend Op</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EBlendOp
	 * @generated
	 */
	EEnum getEBlendOp();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EPipelineStage <em>EPipeline Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EPipeline Stage</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @generated
	 */
	EEnum getEPipelineStage();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EColorSpace <em>EColor Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EColor Space</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EColorSpace
	 * @generated
	 */
	EEnum getEColorSpace();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EFormat <em>EFormat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EFormat</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EFormat
	 * @generated
	 */
	EEnum getEFormat();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EPresentMode <em>EPresent Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EPresent Mode</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EPresentMode
	 * @generated
	 */
	EEnum getEPresentMode();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EPolygonMode <em>EPolygon Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EPolygon Mode</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EPolygonMode
	 * @generated
	 */
	EEnum getEPolygonMode();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EImageUsage <em>EImage Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EImage Usage</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EImageUsage
	 * @generated
	 */
	EEnum getEImageUsage();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EBufferUsage <em>EBuffer Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EBuffer Usage</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EBufferUsage
	 * @generated
	 */
	EEnum getEBufferUsage();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.EMemoryProperty <em>EMemory Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EMemory Property</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.EMemoryProperty
	 * @generated
	 */
	EEnum getEMemoryProperty();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.vulkan.model.enumeration.ESampleCount <em>ESample Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ESample Count</em>'.
	 * @see org.sheepy.vulkan.model.enumeration.ESampleCount
	 * @generated
	 */
	EEnum getESampleCount();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EnumerationFactory getEnumerationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EImageLayout <em>EImage Layout</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEImageLayout()
		 * @generated
		 */
		EEnum EIMAGE_LAYOUT = eINSTANCE.getEImageLayout();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.ECullMode <em>ECull Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.ECullMode
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getECullMode()
		 * @generated
		 */
		EEnum ECULL_MODE = eINSTANCE.getECullMode();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EDescriptorType <em>EDescriptor Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EDescriptorType
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEDescriptorType()
		 * @generated
		 */
		EEnum EDESCRIPTOR_TYPE = eINSTANCE.getEDescriptorType();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EFrontFace <em>EFront Face</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EFrontFace
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEFrontFace()
		 * @generated
		 */
		EEnum EFRONT_FACE = eINSTANCE.getEFrontFace();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EBorderColor <em>EBorder Color</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EBorderColor
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEBorderColor()
		 * @generated
		 */
		EEnum EBORDER_COLOR = eINSTANCE.getEBorderColor();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.ECommandStage <em>ECommand Stage</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.ECommandStage
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getECommandStage()
		 * @generated
		 */
		EEnum ECOMMAND_STAGE = eINSTANCE.getECommandStage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp <em>EAttachment Load Op</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEAttachmentLoadOp()
		 * @generated
		 */
		EEnum EATTACHMENT_LOAD_OP = eINSTANCE.getEAttachmentLoadOp();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.ELogicOp <em>ELogic Op</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.ELogicOp
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getELogicOp()
		 * @generated
		 */
		EEnum ELOGIC_OP = eINSTANCE.getELogicOp();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp <em>EAttachment Store Op</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEAttachmentStoreOp()
		 * @generated
		 */
		EEnum EATTACHMENT_STORE_OP = eINSTANCE.getEAttachmentStoreOp();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EShaderStage <em>EShader Stage</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EShaderStage
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEShaderStage()
		 * @generated
		 */
		EEnum ESHADER_STAGE = eINSTANCE.getEShaderStage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EFilter <em>EFilter</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EFilter
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEFilter()
		 * @generated
		 */
		EEnum EFILTER = eINSTANCE.getEFilter();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode <em>ESampler Mipmap Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getESamplerMipmapMode()
		 * @generated
		 */
		EEnum ESAMPLER_MIPMAP_MODE = eINSTANCE.getESamplerMipmapMode();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.ESamplerAddressMode <em>ESampler Address Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.ESamplerAddressMode
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getESamplerAddressMode()
		 * @generated
		 */
		EEnum ESAMPLER_ADDRESS_MODE = eINSTANCE.getESamplerAddressMode();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EBlendFactor <em>EBlend Factor</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EBlendFactor
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEBlendFactor()
		 * @generated
		 */
		EEnum EBLEND_FACTOR = eINSTANCE.getEBlendFactor();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EDynamicState <em>EDynamic State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EDynamicState
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEDynamicState()
		 * @generated
		 */
		EEnum EDYNAMIC_STATE = eINSTANCE.getEDynamicState();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EBlendOp <em>EBlend Op</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EBlendOp
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEBlendOp()
		 * @generated
		 */
		EEnum EBLEND_OP = eINSTANCE.getEBlendOp();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EPipelineStage <em>EPipeline Stage</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEPipelineStage()
		 * @generated
		 */
		EEnum EPIPELINE_STAGE = eINSTANCE.getEPipelineStage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EColorSpace <em>EColor Space</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EColorSpace
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEColorSpace()
		 * @generated
		 */
		EEnum ECOLOR_SPACE = eINSTANCE.getEColorSpace();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EFormat <em>EFormat</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EFormat
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEFormat()
		 * @generated
		 */
		EEnum EFORMAT = eINSTANCE.getEFormat();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EPresentMode <em>EPresent Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EPresentMode
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEPresentMode()
		 * @generated
		 */
		EEnum EPRESENT_MODE = eINSTANCE.getEPresentMode();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EPolygonMode <em>EPolygon Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EPolygonMode
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEPolygonMode()
		 * @generated
		 */
		EEnum EPOLYGON_MODE = eINSTANCE.getEPolygonMode();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EImageUsage <em>EImage Usage</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EImageUsage
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEImageUsage()
		 * @generated
		 */
		EEnum EIMAGE_USAGE = eINSTANCE.getEImageUsage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EBufferUsage <em>EBuffer Usage</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EBufferUsage
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEBufferUsage()
		 * @generated
		 */
		EEnum EBUFFER_USAGE = eINSTANCE.getEBufferUsage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.EMemoryProperty <em>EMemory Property</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.EMemoryProperty
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getEMemoryProperty()
		 * @generated
		 */
		EEnum EMEMORY_PROPERTY = eINSTANCE.getEMemoryProperty();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.enumeration.ESampleCount <em>ESample Count</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.enumeration.ESampleCount
		 * @see org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl#getESampleCount()
		 * @generated
		 */
		EEnum ESAMPLE_COUNT = eINSTANCE.getESampleCount();

	}

} //EnumerationPackage
