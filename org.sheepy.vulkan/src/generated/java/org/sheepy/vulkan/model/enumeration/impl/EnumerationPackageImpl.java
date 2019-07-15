/**
 */
package org.sheepy.vulkan.model.enumeration.impl;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EBlendFactor;
import org.sheepy.vulkan.model.enumeration.EBlendOp;
import org.sheepy.vulkan.model.enumeration.EBorderColor;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EColorSpace;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.enumeration.ECullMode;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EDynamicState;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EFrontFace;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EIndexType;
import org.sheepy.vulkan.model.enumeration.EInputRate;
import org.sheepy.vulkan.model.enumeration.ELogicOp;
import org.sheepy.vulkan.model.enumeration.EMemoryProperty;
import org.sheepy.vulkan.model.enumeration.EPhysicalDeviceFeature;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.EPolygonMode;
import org.sheepy.vulkan.model.enumeration.EPresentMode;
import org.sheepy.vulkan.model.enumeration.EPrimitiveTopology;
import org.sheepy.vulkan.model.enumeration.ESampleCount;
import org.sheepy.vulkan.model.enumeration.ESamplerAddressMode;
import org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.enumeration.EnumerationFactory;
import org.sheepy.vulkan.model.enumeration.EnumerationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnumerationPackageImpl extends EPackageImpl implements EnumerationPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eImageLayoutEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ePhysicalDeviceFeatureEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eCullModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eDescriptorTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eFrontFaceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eBorderColorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eCommandStageEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eAttachmentLoadOpEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eLogicOpEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ePrimitiveTopologyEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eAttachmentStoreOpEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eShaderStageEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eFilterEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eSamplerMipmapModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eSamplerAddressModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eBlendFactorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eIndexTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eInputRateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eDynamicStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eBlendOpEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eAccessEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ePipelineStageEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eColorSpaceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eFormatEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ePresentModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ePolygonModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eImageUsageEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eBufferUsageEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eMemoryPropertyEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eSampleCountEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.sheepy.vulkan.model.enumeration.EnumerationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EnumerationPackageImpl()
	{
		super(eNS_URI, EnumerationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link EnumerationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EnumerationPackage init()
	{
		if (isInited) return (EnumerationPackage) EPackage.Registry.INSTANCE
				.getEPackage(EnumerationPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredEnumerationPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		EnumerationPackageImpl theEnumerationPackage = registeredEnumerationPackage instanceof EnumerationPackageImpl
				? (EnumerationPackageImpl) registeredEnumerationPackage
				: new EnumerationPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theEnumerationPackage.createPackageContents();

		// Initialize created meta-data
		theEnumerationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEnumerationPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EnumerationPackage.eNS_URI, theEnumerationPackage);
		return theEnumerationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEImageLayout()
	{
		return eImageLayoutEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEPhysicalDeviceFeature()
	{
		return ePhysicalDeviceFeatureEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getECullMode()
	{
		return eCullModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEDescriptorType()
	{
		return eDescriptorTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEFrontFace()
	{
		return eFrontFaceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEBorderColor()
	{
		return eBorderColorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getECommandStage()
	{
		return eCommandStageEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEAttachmentLoadOp()
	{
		return eAttachmentLoadOpEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getELogicOp()
	{
		return eLogicOpEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEPrimitiveTopology()
	{
		return ePrimitiveTopologyEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEAttachmentStoreOp()
	{
		return eAttachmentStoreOpEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEShaderStage()
	{
		return eShaderStageEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEFilter()
	{
		return eFilterEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getESamplerMipmapMode()
	{
		return eSamplerMipmapModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getESamplerAddressMode()
	{
		return eSamplerAddressModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEBlendFactor()
	{
		return eBlendFactorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEIndexType()
	{
		return eIndexTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEInputRate()
	{
		return eInputRateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEDynamicState()
	{
		return eDynamicStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEBlendOp()
	{
		return eBlendOpEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEAccess()
	{
		return eAccessEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEPipelineStage()
	{
		return ePipelineStageEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEColorSpace()
	{
		return eColorSpaceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEFormat()
	{
		return eFormatEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEPresentMode()
	{
		return ePresentModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEPolygonMode()
	{
		return ePolygonModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEImageUsage()
	{
		return eImageUsageEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEBufferUsage()
	{
		return eBufferUsageEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEMemoryProperty()
	{
		return eMemoryPropertyEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getESampleCount()
	{
		return eSampleCountEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumerationFactory getEnumerationFactory()
	{
		return (EnumerationFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create enums
		eImageLayoutEEnum = createEEnum(EIMAGE_LAYOUT);
		ePhysicalDeviceFeatureEEnum = createEEnum(EPHYSICAL_DEVICE_FEATURE);
		eCullModeEEnum = createEEnum(ECULL_MODE);
		eDescriptorTypeEEnum = createEEnum(EDESCRIPTOR_TYPE);
		eFrontFaceEEnum = createEEnum(EFRONT_FACE);
		eBorderColorEEnum = createEEnum(EBORDER_COLOR);
		eCommandStageEEnum = createEEnum(ECOMMAND_STAGE);
		eAttachmentLoadOpEEnum = createEEnum(EATTACHMENT_LOAD_OP);
		eLogicOpEEnum = createEEnum(ELOGIC_OP);
		ePrimitiveTopologyEEnum = createEEnum(EPRIMITIVE_TOPOLOGY);
		eAttachmentStoreOpEEnum = createEEnum(EATTACHMENT_STORE_OP);
		eShaderStageEEnum = createEEnum(ESHADER_STAGE);
		eFilterEEnum = createEEnum(EFILTER);
		eSamplerMipmapModeEEnum = createEEnum(ESAMPLER_MIPMAP_MODE);
		eSamplerAddressModeEEnum = createEEnum(ESAMPLER_ADDRESS_MODE);
		eBlendFactorEEnum = createEEnum(EBLEND_FACTOR);
		eIndexTypeEEnum = createEEnum(EINDEX_TYPE);
		eInputRateEEnum = createEEnum(EINPUT_RATE);
		eDynamicStateEEnum = createEEnum(EDYNAMIC_STATE);
		eBlendOpEEnum = createEEnum(EBLEND_OP);
		eAccessEEnum = createEEnum(EACCESS);
		ePipelineStageEEnum = createEEnum(EPIPELINE_STAGE);
		eColorSpaceEEnum = createEEnum(ECOLOR_SPACE);
		eFormatEEnum = createEEnum(EFORMAT);
		ePresentModeEEnum = createEEnum(EPRESENT_MODE);
		ePolygonModeEEnum = createEEnum(EPOLYGON_MODE);
		eImageUsageEEnum = createEEnum(EIMAGE_USAGE);
		eBufferUsageEEnum = createEEnum(EBUFFER_USAGE);
		eMemoryPropertyEEnum = createEEnum(EMEMORY_PROPERTY);
		eSampleCountEEnum = createEEnum(ESAMPLE_COUNT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Initialize enums and add enum literals
		initEEnum(eImageLayoutEEnum, EImageLayout.class, "EImageLayout");
		addEEnumLiteral(eImageLayoutEEnum, EImageLayout.UNDEFINED);
		addEEnumLiteral(eImageLayoutEEnum, EImageLayout.GENERAL);
		addEEnumLiteral(eImageLayoutEEnum, EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		addEEnumLiteral(eImageLayoutEEnum, EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL);
		addEEnumLiteral(eImageLayoutEEnum, EImageLayout.DEPTH_STENCIL_READ_ONLY_OPTIMAL);
		addEEnumLiteral(eImageLayoutEEnum, EImageLayout.SHADER_READ_ONLY_OPTIMAL);
		addEEnumLiteral(eImageLayoutEEnum, EImageLayout.TRANSFER_SRC_OPTIMAL);
		addEEnumLiteral(eImageLayoutEEnum, EImageLayout.TRANSFER_DST_OPTIMAL);
		addEEnumLiteral(eImageLayoutEEnum, EImageLayout.PREINITIALIZED);
		addEEnumLiteral(eImageLayoutEEnum, EImageLayout.PRESENT_SRC_KHR);

		initEEnum(ePhysicalDeviceFeatureEEnum, EPhysicalDeviceFeature.class,
				"EPhysicalDeviceFeature");
		addEEnumLiteral(ePhysicalDeviceFeatureEEnum, EPhysicalDeviceFeature.GEOMETRY_SHADER);
		addEEnumLiteral(ePhysicalDeviceFeatureEEnum, EPhysicalDeviceFeature.FILL_MODE_NON_SOLID);
		addEEnumLiteral(ePhysicalDeviceFeatureEEnum, EPhysicalDeviceFeature.WIDE_LINES);
		addEEnumLiteral(ePhysicalDeviceFeatureEEnum,
				EPhysicalDeviceFeature.FRAGMENT_STORES_AND_ATOMICS);

		initEEnum(eCullModeEEnum, ECullMode.class, "ECullMode");
		addEEnumLiteral(eCullModeEEnum, ECullMode.NONE);
		addEEnumLiteral(eCullModeEEnum, ECullMode.FRONT_BIT);
		addEEnumLiteral(eCullModeEEnum, ECullMode.BACK_BIT);
		addEEnumLiteral(eCullModeEEnum, ECullMode.FRONT_AND_BACK);

		initEEnum(eDescriptorTypeEEnum, EDescriptorType.class, "EDescriptorType");
		addEEnumLiteral(eDescriptorTypeEEnum, EDescriptorType.SAMPLER);
		addEEnumLiteral(eDescriptorTypeEEnum, EDescriptorType.COMBINED_IMAGE_SAMPLER);
		addEEnumLiteral(eDescriptorTypeEEnum, EDescriptorType.SAMPLED_IMAGE);
		addEEnumLiteral(eDescriptorTypeEEnum, EDescriptorType.STORAGE_IMAGE);
		addEEnumLiteral(eDescriptorTypeEEnum, EDescriptorType.UNIFORM_TEXEL_BUFFER);
		addEEnumLiteral(eDescriptorTypeEEnum, EDescriptorType.STORAGE_TEXEL_BUFFER);
		addEEnumLiteral(eDescriptorTypeEEnum, EDescriptorType.UNIFORM_BUFFER);
		addEEnumLiteral(eDescriptorTypeEEnum, EDescriptorType.STORAGE_BUFFER);
		addEEnumLiteral(eDescriptorTypeEEnum, EDescriptorType.UNIFORM_BUFFER_DYNAMIC);
		addEEnumLiteral(eDescriptorTypeEEnum, EDescriptorType.STORAGE_BUFFER_DYNAMIC);
		addEEnumLiteral(eDescriptorTypeEEnum, EDescriptorType.INPUT_ATTACHMENT);

		initEEnum(eFrontFaceEEnum, EFrontFace.class, "EFrontFace");
		addEEnumLiteral(eFrontFaceEEnum, EFrontFace.COUNTER_CLOCKWISE);
		addEEnumLiteral(eFrontFaceEEnum, EFrontFace.CLOCKWISE);

		initEEnum(eBorderColorEEnum, EBorderColor.class, "EBorderColor");
		addEEnumLiteral(eBorderColorEEnum, EBorderColor.FLOAT_TRANSPARENT_BLACK);
		addEEnumLiteral(eBorderColorEEnum, EBorderColor.INT_TRANSPARENT_BLACK);
		addEEnumLiteral(eBorderColorEEnum, EBorderColor.FLOAT_OPAQUE_BLACK);
		addEEnumLiteral(eBorderColorEEnum, EBorderColor.INT_OPAQUE_BLACK);
		addEEnumLiteral(eBorderColorEEnum, EBorderColor.FLOAT_OPAQUE_WHITE);
		addEEnumLiteral(eBorderColorEEnum, EBorderColor.INT_OPAQUE_WHITE);

		initEEnum(eCommandStageEEnum, ECommandStage.class, "ECommandStage");
		addEEnumLiteral(eCommandStageEEnum, ECommandStage.TRANSFER);
		addEEnumLiteral(eCommandStageEEnum, ECommandStage.COMPUTE);
		addEEnumLiteral(eCommandStageEEnum, ECommandStage.PRE_RENDER);
		addEEnumLiteral(eCommandStageEEnum, ECommandStage.RENDER);
		addEEnumLiteral(eCommandStageEEnum, ECommandStage.POST_RENDER);

		initEEnum(eAttachmentLoadOpEEnum, EAttachmentLoadOp.class, "EAttachmentLoadOp");
		addEEnumLiteral(eAttachmentLoadOpEEnum, EAttachmentLoadOp.LOAD);
		addEEnumLiteral(eAttachmentLoadOpEEnum, EAttachmentLoadOp.CLEAR);
		addEEnumLiteral(eAttachmentLoadOpEEnum, EAttachmentLoadOp.DONT_CARE);

		initEEnum(eLogicOpEEnum, ELogicOp.class, "ELogicOp");
		addEEnumLiteral(eLogicOpEEnum, ELogicOp.CLEAR);
		addEEnumLiteral(eLogicOpEEnum, ELogicOp.AND);
		addEEnumLiteral(eLogicOpEEnum, ELogicOp.AND_REVERSE);
		addEEnumLiteral(eLogicOpEEnum, ELogicOp.COPY);
		addEEnumLiteral(eLogicOpEEnum, ELogicOp.AND_INVERTED);
		addEEnumLiteral(eLogicOpEEnum, ELogicOp.NO_OP);
		addEEnumLiteral(eLogicOpEEnum, ELogicOp.XOR);
		addEEnumLiteral(eLogicOpEEnum, ELogicOp.OR);
		addEEnumLiteral(eLogicOpEEnum, ELogicOp.NOR);
		addEEnumLiteral(eLogicOpEEnum, ELogicOp.EQUIVALENT);
		addEEnumLiteral(eLogicOpEEnum, ELogicOp.INVERT);
		addEEnumLiteral(eLogicOpEEnum, ELogicOp.OR_REVERSE);
		addEEnumLiteral(eLogicOpEEnum, ELogicOp.COPY_INVERTED);
		addEEnumLiteral(eLogicOpEEnum, ELogicOp.OR_INVERTED);
		addEEnumLiteral(eLogicOpEEnum, ELogicOp.NAND);
		addEEnumLiteral(eLogicOpEEnum, ELogicOp.SET);

		initEEnum(ePrimitiveTopologyEEnum, EPrimitiveTopology.class, "EPrimitiveTopology");
		addEEnumLiteral(ePrimitiveTopologyEEnum, EPrimitiveTopology.POINT_LIST);
		addEEnumLiteral(ePrimitiveTopologyEEnum, EPrimitiveTopology.LINE_LIST);
		addEEnumLiteral(ePrimitiveTopologyEEnum, EPrimitiveTopology.LINE_STRIP);
		addEEnumLiteral(ePrimitiveTopologyEEnum, EPrimitiveTopology.TRIANGLE_LIST);
		addEEnumLiteral(ePrimitiveTopologyEEnum, EPrimitiveTopology.TRIANGLE_STRIP);
		addEEnumLiteral(ePrimitiveTopologyEEnum, EPrimitiveTopology.TRIANGLE_FAN);
		addEEnumLiteral(ePrimitiveTopologyEEnum, EPrimitiveTopology.LINE_LIST_WITH_ADJACENCY);
		addEEnumLiteral(ePrimitiveTopologyEEnum, EPrimitiveTopology.LINE_STRIP_WITH_ADJACENCY);
		addEEnumLiteral(ePrimitiveTopologyEEnum, EPrimitiveTopology.TRIANGLE_LIST_WITH_ADJACENCY);
		addEEnumLiteral(ePrimitiveTopologyEEnum, EPrimitiveTopology.TRIANGLE_STRIP_WITH_ADJACENCY);
		addEEnumLiteral(ePrimitiveTopologyEEnum, EPrimitiveTopology.PATCH_LIST);

		initEEnum(eAttachmentStoreOpEEnum, EAttachmentStoreOp.class, "EAttachmentStoreOp");
		addEEnumLiteral(eAttachmentStoreOpEEnum, EAttachmentStoreOp.STORE);
		addEEnumLiteral(eAttachmentStoreOpEEnum, EAttachmentStoreOp.DONT_CARE);

		initEEnum(eShaderStageEEnum, EShaderStage.class, "EShaderStage");
		addEEnumLiteral(eShaderStageEEnum, EShaderStage.VERTEX_BIT);
		addEEnumLiteral(eShaderStageEEnum, EShaderStage.TESSELLATION_CONTROL_BIT);
		addEEnumLiteral(eShaderStageEEnum, EShaderStage.TESSELLATION_EVALUATION_BIT);
		addEEnumLiteral(eShaderStageEEnum, EShaderStage.GEOMETRY_BIT);
		addEEnumLiteral(eShaderStageEEnum, EShaderStage.FRAGMENT_BIT);
		addEEnumLiteral(eShaderStageEEnum, EShaderStage.COMPUTE_BIT);
		addEEnumLiteral(eShaderStageEEnum, EShaderStage.ALL_GRAPHICS);
		addEEnumLiteral(eShaderStageEEnum, EShaderStage.ALL);

		initEEnum(eFilterEEnum, EFilter.class, "EFilter");
		addEEnumLiteral(eFilterEEnum, EFilter.NEAREST);
		addEEnumLiteral(eFilterEEnum, EFilter.LINEAR);

		initEEnum(eSamplerMipmapModeEEnum, ESamplerMipmapMode.class, "ESamplerMipmapMode");
		addEEnumLiteral(eSamplerMipmapModeEEnum, ESamplerMipmapMode.NEAREST);
		addEEnumLiteral(eSamplerMipmapModeEEnum, ESamplerMipmapMode.LINEAR);

		initEEnum(eSamplerAddressModeEEnum, ESamplerAddressMode.class, "ESamplerAddressMode");
		addEEnumLiteral(eSamplerAddressModeEEnum, ESamplerAddressMode.REPEAT);
		addEEnumLiteral(eSamplerAddressModeEEnum, ESamplerAddressMode.MIRRORED_REPEAT);
		addEEnumLiteral(eSamplerAddressModeEEnum, ESamplerAddressMode.CLAMP_TO_EDGE);
		addEEnumLiteral(eSamplerAddressModeEEnum, ESamplerAddressMode.CLAMP_TO_BORDER);

		initEEnum(eBlendFactorEEnum, EBlendFactor.class, "EBlendFactor");
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.ZERO);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.ONE);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.SRC_COLOR);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.ONE_MINUS_SRC_COLOR);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.DST_COLOR);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.ONE_MINUS_DST_COLOR);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.SRC_ALPHA);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.ONE_MINUS_SRC_ALPHA);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.DST_ALPHA);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.ONE_MINUS_DST_ALPHA);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.CONSTANT_COLOR);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.ONE_MINUS_CONSTANT_COLOR);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.CONSTANT_ALPHA);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.ONE_MINUS_CONSTANT_ALPHA);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.SRC_ALPHA_SATURATE);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.SRC1_COLOR);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.ONE_MINUS_SRC1_COLOR);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.SRC1_ALPHA);
		addEEnumLiteral(eBlendFactorEEnum, EBlendFactor.ONE_MINUS_SRC1_ALPHA);

		initEEnum(eIndexTypeEEnum, EIndexType.class, "EIndexType");
		addEEnumLiteral(eIndexTypeEEnum, EIndexType.UINT16);
		addEEnumLiteral(eIndexTypeEEnum, EIndexType.UINT32);

		initEEnum(eInputRateEEnum, EInputRate.class, "EInputRate");
		addEEnumLiteral(eInputRateEEnum, EInputRate.VERTEX);
		addEEnumLiteral(eInputRateEEnum, EInputRate.INSTANCE);

		initEEnum(eDynamicStateEEnum, EDynamicState.class, "EDynamicState");
		addEEnumLiteral(eDynamicStateEEnum, EDynamicState.VIEWPORT);
		addEEnumLiteral(eDynamicStateEEnum, EDynamicState.SCISSOR);
		addEEnumLiteral(eDynamicStateEEnum, EDynamicState.LINE_WIDTH);
		addEEnumLiteral(eDynamicStateEEnum, EDynamicState.DEPTH_BIAS);
		addEEnumLiteral(eDynamicStateEEnum, EDynamicState.BLEND_CONSTANTS);
		addEEnumLiteral(eDynamicStateEEnum, EDynamicState.DEPTH_BOUNDS);
		addEEnumLiteral(eDynamicStateEEnum, EDynamicState.STENCIL_COMPARE_MASK);
		addEEnumLiteral(eDynamicStateEEnum, EDynamicState.STENCIL_WRITE_MASK);
		addEEnumLiteral(eDynamicStateEEnum, EDynamicState.STENCIL_REFERENCE);

		initEEnum(eBlendOpEEnum, EBlendOp.class, "EBlendOp");
		addEEnumLiteral(eBlendOpEEnum, EBlendOp.ADD);
		addEEnumLiteral(eBlendOpEEnum, EBlendOp.SUBTRACT);
		addEEnumLiteral(eBlendOpEEnum, EBlendOp.REVERSE_SUBTRACT);
		addEEnumLiteral(eBlendOpEEnum, EBlendOp.MIN);
		addEEnumLiteral(eBlendOpEEnum, EBlendOp.MAX);

		initEEnum(eAccessEEnum, EAccess.class, "EAccess");
		addEEnumLiteral(eAccessEEnum, EAccess.UNDEFINED);
		addEEnumLiteral(eAccessEEnum, EAccess.INDIRECT_COMMAND_READ_BIT);
		addEEnumLiteral(eAccessEEnum, EAccess.INDEX_READ_BIT);
		addEEnumLiteral(eAccessEEnum, EAccess.VERTEX_ATTRIBUTE_READ_BIT);
		addEEnumLiteral(eAccessEEnum, EAccess.UNIFORM_READ_BIT);
		addEEnumLiteral(eAccessEEnum, EAccess.INPUT_ATTACHMENT_READ_BIT);
		addEEnumLiteral(eAccessEEnum, EAccess.SHADER_READ_BIT);
		addEEnumLiteral(eAccessEEnum, EAccess.SHADER_WRITE_BIT);
		addEEnumLiteral(eAccessEEnum, EAccess.COLOR_ATTACHMENT_READ_BIT);
		addEEnumLiteral(eAccessEEnum, EAccess.COLOR_ATTACHMENT_WRITE_BIT);
		addEEnumLiteral(eAccessEEnum, EAccess.DEPTH_STENCIL_ATTACHMENT_READ_BIT);
		addEEnumLiteral(eAccessEEnum, EAccess.DEPTH_STENCIL_ATTACHMENT_WRITE_BIT);
		addEEnumLiteral(eAccessEEnum, EAccess.TRANSFER_READ_BIT);
		addEEnumLiteral(eAccessEEnum, EAccess.TRANSFER_WRITE_BIT);
		addEEnumLiteral(eAccessEEnum, EAccess.HOST_READ_BIT);
		addEEnumLiteral(eAccessEEnum, EAccess.HOST_WRITE_BIT);
		addEEnumLiteral(eAccessEEnum, EAccess.MEMORY_READ_BIT);
		addEEnumLiteral(eAccessEEnum, EAccess.MEMORY_WRITE_BIT);

		initEEnum(ePipelineStageEEnum, EPipelineStage.class, "EPipelineStage");
		addEEnumLiteral(ePipelineStageEEnum, EPipelineStage.TOP_OF_PIPE_BIT);
		addEEnumLiteral(ePipelineStageEEnum, EPipelineStage.DRAW_INDIRECT_BIT);
		addEEnumLiteral(ePipelineStageEEnum, EPipelineStage.VERTEX_INPUT_BIT);
		addEEnumLiteral(ePipelineStageEEnum, EPipelineStage.VERTEX_SHADER_BIT);
		addEEnumLiteral(ePipelineStageEEnum, EPipelineStage.TESSELLATION_CONTROL_SHADER_BIT);
		addEEnumLiteral(ePipelineStageEEnum, EPipelineStage.TESSELLATION_EVALUATION_SHADER_BIT);
		addEEnumLiteral(ePipelineStageEEnum, EPipelineStage.GEOMETRY_SHADER_BIT);
		addEEnumLiteral(ePipelineStageEEnum, EPipelineStage.FRAGMENT_SHADER_BIT);
		addEEnumLiteral(ePipelineStageEEnum, EPipelineStage.EARLY_FRAGMENT_TESTS_BIT);
		addEEnumLiteral(ePipelineStageEEnum, EPipelineStage.LATE_FRAGMENT_TESTS_BIT);
		addEEnumLiteral(ePipelineStageEEnum, EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT);
		addEEnumLiteral(ePipelineStageEEnum, EPipelineStage.COMPUTE_SHADER_BIT);
		addEEnumLiteral(ePipelineStageEEnum, EPipelineStage.TRANSFER_BIT);
		addEEnumLiteral(ePipelineStageEEnum, EPipelineStage.BOTTOM_OF_PIPE_BIT);
		addEEnumLiteral(ePipelineStageEEnum, EPipelineStage.HOST_BIT);
		addEEnumLiteral(ePipelineStageEEnum, EPipelineStage.ALL_GRAPHICS_BIT);
		addEEnumLiteral(ePipelineStageEEnum, EPipelineStage.ALL_COMMANDS_BIT);

		initEEnum(eColorSpaceEEnum, EColorSpace.class, "EColorSpace");
		addEEnumLiteral(eColorSpaceEEnum, EColorSpace.SRGB_NONLINEAR_KHR);

		initEEnum(eFormatEEnum, EFormat.class, "EFormat");
		addEEnumLiteral(eFormatEEnum, EFormat.UNDEFINED);
		addEEnumLiteral(eFormatEEnum, EFormat.R4G4_UNORM_PACK8);
		addEEnumLiteral(eFormatEEnum, EFormat.R4G4B4A4_UNORM_PACK16);
		addEEnumLiteral(eFormatEEnum, EFormat.B4G4R4A4_UNORM_PACK16);
		addEEnumLiteral(eFormatEEnum, EFormat.R5G6B5_UNORM_PACK16);
		addEEnumLiteral(eFormatEEnum, EFormat.B5G6R5_UNORM_PACK16);
		addEEnumLiteral(eFormatEEnum, EFormat.R5G5B5A1_UNORM_PACK16);
		addEEnumLiteral(eFormatEEnum, EFormat.B5G5R5A1_UNORM_PACK16);
		addEEnumLiteral(eFormatEEnum, EFormat.A1R5G5B5_UNORM_PACK16);
		addEEnumLiteral(eFormatEEnum, EFormat.R8_UNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.R8_SNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.R8_USCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.R8_SSCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.R8_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R8_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R8_SRGB);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8_UNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8_SNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8_USCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8_SSCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8_SRGB);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8B8_UNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8B8_SNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8B8_USCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8B8_SSCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8B8_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8B8_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8B8_SRGB);
		addEEnumLiteral(eFormatEEnum, EFormat.B8G8R8_UNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.B8G8R8_SNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.B8G8R8_USCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.B8G8R8_SSCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.B8G8R8_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.B8G8R8_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.B8G8R8_SRGB);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8B8A8_UNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8B8A8_SNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8B8A8_USCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8B8A8_SSCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8B8A8_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8B8A8_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R8G8B8A8_SRGB);
		addEEnumLiteral(eFormatEEnum, EFormat.B8G8R8A8_UNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.B8G8R8A8_SNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.B8G8R8A8_USCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.B8G8R8A8_SSCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.B8G8R8A8_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.B8G8R8A8_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.B8G8R8A8_SRGB);
		addEEnumLiteral(eFormatEEnum, EFormat.A8B8G8R8_UNORM_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A8B8G8R8_SNORM_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A8B8G8R8_USCALED_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A8B8G8R8_SSCALED_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A8B8G8R8_UINT_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A8B8G8R8_SINT_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A8B8G8R8_SRGB_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A2R10G10B10_UNORM_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A2R10G10B10_SNORM_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A2R10G10B10_USCALED_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A2R10G10B10_SSCALED_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A2R10G10B10_UINT_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A2R10G10B10_SINT_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A2B10G10R10_UNORM_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A2B10G10R10_SNORM_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A2B10G10R10_USCALED_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A2B10G10R10_SSCALED_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A2B10G10R10_UINT_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.A2B10G10R10_SINT_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.R16_UNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.R16_SNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.R16_USCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.R16_SSCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.R16_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R16_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R16_SFLOAT);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16_UNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16_SNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16_USCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16_SSCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16_SFLOAT);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16B16_UNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16B16_SNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16B16_USCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16B16_SSCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16B16_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16B16_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16B16_SFLOAT);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16B16A16_UNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16B16A16_SNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16B16A16_USCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16B16A16_SSCALED);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16B16A16_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16B16A16_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R16G16B16A16_SFLOAT);
		addEEnumLiteral(eFormatEEnum, EFormat.R32_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R32_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R32_SFLOAT);
		addEEnumLiteral(eFormatEEnum, EFormat.R32G32_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R32G32_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R32G32_SFLOAT);
		addEEnumLiteral(eFormatEEnum, EFormat.R32G32B32_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R32G32B32_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R32G32B32_SFLOAT);
		addEEnumLiteral(eFormatEEnum, EFormat.R32G32B32A32_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R32G32B32A32_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R32G32B32A32_SFLOAT);
		addEEnumLiteral(eFormatEEnum, EFormat.R64_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R64_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R64_SFLOAT);
		addEEnumLiteral(eFormatEEnum, EFormat.R64G64_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R64G64_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R64G64_SFLOAT);
		addEEnumLiteral(eFormatEEnum, EFormat.R64G64B64_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R64G64B64_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R64G64B64_SFLOAT);
		addEEnumLiteral(eFormatEEnum, EFormat.R64G64B64A64_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R64G64B64A64_SINT);
		addEEnumLiteral(eFormatEEnum, EFormat.R64G64B64A64_SFLOAT);
		addEEnumLiteral(eFormatEEnum, EFormat.B10G11R11_UFLOAT_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.E5B9G9R9_UFLOAT_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.D16_UNORM);
		addEEnumLiteral(eFormatEEnum, EFormat.X8_D24_UNORM_PACK32);
		addEEnumLiteral(eFormatEEnum, EFormat.D32_SFLOAT);
		addEEnumLiteral(eFormatEEnum, EFormat.S8_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.D16_UNORM_S8_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.D24_UNORM_S8_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.D32_SFLOAT_S8_UINT);
		addEEnumLiteral(eFormatEEnum, EFormat.BC1_RGB_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.BC1_RGB_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.BC1_RGBA_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.BC1_RGBA_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.BC2_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.BC2_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.BC3_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.BC3_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.BC4_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.BC4_SNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.BC5_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.BC5_SNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.BC6H_UFLOAT_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.BC6H_SFLOAT_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.BC7_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.BC7_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ETC2_R8G8B8_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ETC2_R8G8B8_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ETC2_R8G8B8A1_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ETC2_R8G8B8A1_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ETC2_R8G8B8A8_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ETC2_R8G8B8A8_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.EAC_R11_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.EAC_R11_SNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.EAC_R11G11_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.EAC_R11G11_SNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_4X4_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_4X4_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_5X4_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_5X4_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_5X5_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_5X5_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_6X5_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_6X5_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_6X6_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_6X6_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_8X5_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_8X5_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_8X6_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_8X6_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_8X8_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_8X8_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_10X5_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_10X5_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_10X6_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_10X6_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_10X8_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_10X8_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_10X10_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_10X10_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_12X10_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_12X10_SRGB_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_12X12_UNORM_BLOCK);
		addEEnumLiteral(eFormatEEnum, EFormat.ASTC_12X12_SRGB_BLOCK);

		initEEnum(ePresentModeEEnum, EPresentMode.class, "EPresentMode");
		addEEnumLiteral(ePresentModeEEnum, EPresentMode.IMMEDIATE);
		addEEnumLiteral(ePresentModeEEnum, EPresentMode.MAIL_BOX);
		addEEnumLiteral(ePresentModeEEnum, EPresentMode.FIFO);
		addEEnumLiteral(ePresentModeEEnum, EPresentMode.FIFO_RELAXED);

		initEEnum(ePolygonModeEEnum, EPolygonMode.class, "EPolygonMode");
		addEEnumLiteral(ePolygonModeEEnum, EPolygonMode.FILL);
		addEEnumLiteral(ePolygonModeEEnum, EPolygonMode.LINE);
		addEEnumLiteral(ePolygonModeEEnum, EPolygonMode.POINT);

		initEEnum(eImageUsageEEnum, EImageUsage.class, "EImageUsage");
		addEEnumLiteral(eImageUsageEEnum, EImageUsage.TRANSFER_SRC);
		addEEnumLiteral(eImageUsageEEnum, EImageUsage.TRANSFER_DST);
		addEEnumLiteral(eImageUsageEEnum, EImageUsage.SAMPLED);
		addEEnumLiteral(eImageUsageEEnum, EImageUsage.STORAGE);
		addEEnumLiteral(eImageUsageEEnum, EImageUsage.COLOR_ATTACHMENT);
		addEEnumLiteral(eImageUsageEEnum, EImageUsage.DEPTH_STENCIL_ATTACHMENT);
		addEEnumLiteral(eImageUsageEEnum, EImageUsage.TRANSIENT_ATTACHMENT);
		addEEnumLiteral(eImageUsageEEnum, EImageUsage.INPUT_ATTACHEMENT);

		initEEnum(eBufferUsageEEnum, EBufferUsage.class, "EBufferUsage");
		addEEnumLiteral(eBufferUsageEEnum, EBufferUsage.TRANSFER_SRC_BIT);
		addEEnumLiteral(eBufferUsageEEnum, EBufferUsage.TRANSFER_DST_BIT);
		addEEnumLiteral(eBufferUsageEEnum, EBufferUsage.UNIFORM_TEXEL_BUFFER_BIT);
		addEEnumLiteral(eBufferUsageEEnum, EBufferUsage.STORAGE_TEXEL_BUFFER_BIT);
		addEEnumLiteral(eBufferUsageEEnum, EBufferUsage.UNIFORM_BUFFER_BIT);
		addEEnumLiteral(eBufferUsageEEnum, EBufferUsage.STORAGE_BUFFER_BIT);
		addEEnumLiteral(eBufferUsageEEnum, EBufferUsage.INDEX_BUFFER_BIT);
		addEEnumLiteral(eBufferUsageEEnum, EBufferUsage.VERTEX_BUFFER_BIT);
		addEEnumLiteral(eBufferUsageEEnum, EBufferUsage.INDIRECT_BUFFER_BIT);

		initEEnum(eMemoryPropertyEEnum, EMemoryProperty.class, "EMemoryProperty");
		addEEnumLiteral(eMemoryPropertyEEnum, EMemoryProperty.DEVICE_LOCAL_BIT);
		addEEnumLiteral(eMemoryPropertyEEnum, EMemoryProperty.HOST_VISIBLE_BIT);
		addEEnumLiteral(eMemoryPropertyEEnum, EMemoryProperty.HOST_COHERENT_BIT);
		addEEnumLiteral(eMemoryPropertyEEnum, EMemoryProperty.HOST_CACHED_BIT);
		addEEnumLiteral(eMemoryPropertyEEnum, EMemoryProperty.LAZILY_ALLOCATED_BIT);

		initEEnum(eSampleCountEEnum, ESampleCount.class, "ESampleCount");
		addEEnumLiteral(eSampleCountEEnum, ESampleCount.SAMPLE_COUNT_1BIT);
		addEEnumLiteral(eSampleCountEEnum, ESampleCount.SAMPLE_COUNT_2BIT);
		addEEnumLiteral(eSampleCountEEnum, ESampleCount.SAMPLE_COUNT_4BIT);
		addEEnumLiteral(eSampleCountEEnum, ESampleCount.SAMPLE_COUNT_8BIT);
		addEEnumLiteral(eSampleCountEEnum, ESampleCount.SAMPLE_COUNT_16_BIT);
		addEEnumLiteral(eSampleCountEEnum, ESampleCount.SAMPLE_COUNT_32_BIT);
		addEEnumLiteral(eSampleCountEEnum, ESampleCount.SAMPLE_COUNT_64_BIT);

		// Create resource
		createResource(eNS_URI);
	}

} //EnumerationPackageImpl
