/**
 */
package org.sheepy.lily.vulkan.model.enumeration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.vulkan.model.enumeration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnumerationFactoryImpl extends EFactoryImpl implements EnumerationFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnumerationFactory init()
	{
		try
		{
			EnumerationFactory theEnumerationFactory = (EnumerationFactory) EPackage.Registry.INSTANCE
					.getEFactory(EnumerationPackage.eNS_URI);
			if (theEnumerationFactory != null)
			{
				return theEnumerationFactory;
			}
		} catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EnumerationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID())
		{
		case EnumerationPackage.EIMAGE_LAYOUT:
			return createEImageLayoutFromString(eDataType, initialValue);
		case EnumerationPackage.EPHYSICAL_DEVICE_FEATURE:
			return createEPhysicalDeviceFeatureFromString(eDataType, initialValue);
		case EnumerationPackage.ECULL_MODE:
			return createECullModeFromString(eDataType, initialValue);
		case EnumerationPackage.EDESCRIPTOR_TYPE:
			return createEDescriptorTypeFromString(eDataType, initialValue);
		case EnumerationPackage.EFRONT_FACE:
			return createEFrontFaceFromString(eDataType, initialValue);
		case EnumerationPackage.EBORDER_COLOR:
			return createEBorderColorFromString(eDataType, initialValue);
		case EnumerationPackage.ECOMMAND_STAGE:
			return createECommandStageFromString(eDataType, initialValue);
		case EnumerationPackage.EATTACHMENT_LOAD_OP:
			return createEAttachmentLoadOpFromString(eDataType, initialValue);
		case EnumerationPackage.ELOGIC_OP:
			return createELogicOpFromString(eDataType, initialValue);
		case EnumerationPackage.EATTACHMENT_STORE_OP:
			return createEAttachmentStoreOpFromString(eDataType, initialValue);
		case EnumerationPackage.ESHADER_STAGE:
			return createEShaderStageFromString(eDataType, initialValue);
		case EnumerationPackage.EFILTER:
			return createEFilterFromString(eDataType, initialValue);
		case EnumerationPackage.ESAMPLER_MIPMAP_MODE:
			return createESamplerMipmapModeFromString(eDataType, initialValue);
		case EnumerationPackage.ESAMPLER_ADDRESS_MODE:
			return createESamplerAddressModeFromString(eDataType, initialValue);
		case EnumerationPackage.EBLEND_FACTOR:
			return createEBlendFactorFromString(eDataType, initialValue);
		case EnumerationPackage.EDYNAMIC_STATE:
			return createEDynamicStateFromString(eDataType, initialValue);
		case EnumerationPackage.EBLEND_OP:
			return createEBlendOpFromString(eDataType, initialValue);
		case EnumerationPackage.EACCESS:
			return createEAccessFromString(eDataType, initialValue);
		case EnumerationPackage.EPIPELINE_STAGE:
			return createEPipelineStageFromString(eDataType, initialValue);
		case EnumerationPackage.ECOLOR_SPACE:
			return createEColorSpaceFromString(eDataType, initialValue);
		case EnumerationPackage.EFORMAT:
			return createEFormatFromString(eDataType, initialValue);
		case EnumerationPackage.EPRESENT_MODE:
			return createEPresentModeFromString(eDataType, initialValue);
		case EnumerationPackage.EPOLYGON_MODE:
			return createEPolygonModeFromString(eDataType, initialValue);
		case EnumerationPackage.EIMAGE_USAGE:
			return createEImageUsageFromString(eDataType, initialValue);
		case EnumerationPackage.EBUFFER_USAGE:
			return createEBufferUsageFromString(eDataType, initialValue);
		case EnumerationPackage.EMEMORY_PROPERTY:
			return createEMemoryPropertyFromString(eDataType, initialValue);
		case EnumerationPackage.ESAMPLE_COUNT:
			return createESampleCountFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID())
		{
		case EnumerationPackage.EIMAGE_LAYOUT:
			return convertEImageLayoutToString(eDataType, instanceValue);
		case EnumerationPackage.EPHYSICAL_DEVICE_FEATURE:
			return convertEPhysicalDeviceFeatureToString(eDataType, instanceValue);
		case EnumerationPackage.ECULL_MODE:
			return convertECullModeToString(eDataType, instanceValue);
		case EnumerationPackage.EDESCRIPTOR_TYPE:
			return convertEDescriptorTypeToString(eDataType, instanceValue);
		case EnumerationPackage.EFRONT_FACE:
			return convertEFrontFaceToString(eDataType, instanceValue);
		case EnumerationPackage.EBORDER_COLOR:
			return convertEBorderColorToString(eDataType, instanceValue);
		case EnumerationPackage.ECOMMAND_STAGE:
			return convertECommandStageToString(eDataType, instanceValue);
		case EnumerationPackage.EATTACHMENT_LOAD_OP:
			return convertEAttachmentLoadOpToString(eDataType, instanceValue);
		case EnumerationPackage.ELOGIC_OP:
			return convertELogicOpToString(eDataType, instanceValue);
		case EnumerationPackage.EATTACHMENT_STORE_OP:
			return convertEAttachmentStoreOpToString(eDataType, instanceValue);
		case EnumerationPackage.ESHADER_STAGE:
			return convertEShaderStageToString(eDataType, instanceValue);
		case EnumerationPackage.EFILTER:
			return convertEFilterToString(eDataType, instanceValue);
		case EnumerationPackage.ESAMPLER_MIPMAP_MODE:
			return convertESamplerMipmapModeToString(eDataType, instanceValue);
		case EnumerationPackage.ESAMPLER_ADDRESS_MODE:
			return convertESamplerAddressModeToString(eDataType, instanceValue);
		case EnumerationPackage.EBLEND_FACTOR:
			return convertEBlendFactorToString(eDataType, instanceValue);
		case EnumerationPackage.EDYNAMIC_STATE:
			return convertEDynamicStateToString(eDataType, instanceValue);
		case EnumerationPackage.EBLEND_OP:
			return convertEBlendOpToString(eDataType, instanceValue);
		case EnumerationPackage.EACCESS:
			return convertEAccessToString(eDataType, instanceValue);
		case EnumerationPackage.EPIPELINE_STAGE:
			return convertEPipelineStageToString(eDataType, instanceValue);
		case EnumerationPackage.ECOLOR_SPACE:
			return convertEColorSpaceToString(eDataType, instanceValue);
		case EnumerationPackage.EFORMAT:
			return convertEFormatToString(eDataType, instanceValue);
		case EnumerationPackage.EPRESENT_MODE:
			return convertEPresentModeToString(eDataType, instanceValue);
		case EnumerationPackage.EPOLYGON_MODE:
			return convertEPolygonModeToString(eDataType, instanceValue);
		case EnumerationPackage.EIMAGE_USAGE:
			return convertEImageUsageToString(eDataType, instanceValue);
		case EnumerationPackage.EBUFFER_USAGE:
			return convertEBufferUsageToString(eDataType, instanceValue);
		case EnumerationPackage.EMEMORY_PROPERTY:
			return convertEMemoryPropertyToString(eDataType, instanceValue);
		case EnumerationPackage.ESAMPLE_COUNT:
			return convertESampleCountToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EImageLayout createEImageLayoutFromString(EDataType eDataType, String initialValue)
	{
		EImageLayout result = EImageLayout.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEImageLayoutToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPhysicalDeviceFeature createEPhysicalDeviceFeatureFromString(	EDataType eDataType,
																			String initialValue)
	{
		EPhysicalDeviceFeature result = EPhysicalDeviceFeature.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEPhysicalDeviceFeatureToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECullMode createECullModeFromString(EDataType eDataType, String initialValue)
	{
		ECullMode result = ECullMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertECullModeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDescriptorType createEDescriptorTypeFromString(EDataType eDataType, String initialValue)
	{
		EDescriptorType result = EDescriptorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEDescriptorTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFrontFace createEFrontFaceFromString(EDataType eDataType, String initialValue)
	{
		EFrontFace result = EFrontFace.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEFrontFaceToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EBorderColor createEBorderColorFromString(EDataType eDataType, String initialValue)
	{
		EBorderColor result = EBorderColor.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEBorderColorToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECommandStage createECommandStageFromString(EDataType eDataType, String initialValue)
	{
		ECommandStage result = ECommandStage.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertECommandStageToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttachmentLoadOp createEAttachmentLoadOpFromString(	EDataType eDataType,
																String initialValue)
	{
		EAttachmentLoadOp result = EAttachmentLoadOp.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEAttachmentLoadOpToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ELogicOp createELogicOpFromString(EDataType eDataType, String initialValue)
	{
		ELogicOp result = ELogicOp.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertELogicOpToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttachmentStoreOp createEAttachmentStoreOpFromString(	EDataType eDataType,
																	String initialValue)
	{
		EAttachmentStoreOp result = EAttachmentStoreOp.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEAttachmentStoreOpToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EShaderStage createEShaderStageFromString(EDataType eDataType, String initialValue)
	{
		EShaderStage result = EShaderStage.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEShaderStageToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFilter createEFilterFromString(EDataType eDataType, String initialValue)
	{
		EFilter result = EFilter.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEFilterToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESamplerMipmapMode createESamplerMipmapModeFromString(	EDataType eDataType,
																	String initialValue)
	{
		ESamplerMipmapMode result = ESamplerMipmapMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertESamplerMipmapModeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESamplerAddressMode createESamplerAddressModeFromString(	EDataType eDataType,
																	String initialValue)
	{
		ESamplerAddressMode result = ESamplerAddressMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertESamplerAddressModeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EBlendFactor createEBlendFactorFromString(EDataType eDataType, String initialValue)
	{
		EBlendFactor result = EBlendFactor.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEBlendFactorToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDynamicState createEDynamicStateFromString(EDataType eDataType, String initialValue)
	{
		EDynamicState result = EDynamicState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEDynamicStateToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EBlendOp createEBlendOpFromString(EDataType eDataType, String initialValue)
	{
		EBlendOp result = EBlendOp.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEBlendOpToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAccess createEAccessFromString(EDataType eDataType, String initialValue)
	{
		EAccess result = EAccess.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEAccessToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPipelineStage createEPipelineStageFromString(EDataType eDataType, String initialValue)
	{
		EPipelineStage result = EPipelineStage.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEPipelineStageToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EColorSpace createEColorSpaceFromString(EDataType eDataType, String initialValue)
	{
		EColorSpace result = EColorSpace.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEColorSpaceToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFormat createEFormatFromString(EDataType eDataType, String initialValue)
	{
		EFormat result = EFormat.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEFormatToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPresentMode createEPresentModeFromString(EDataType eDataType, String initialValue)
	{
		EPresentMode result = EPresentMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEPresentModeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPolygonMode createEPolygonModeFromString(EDataType eDataType, String initialValue)
	{
		EPolygonMode result = EPolygonMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEPolygonModeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EImageUsage createEImageUsageFromString(EDataType eDataType, String initialValue)
	{
		EImageUsage result = EImageUsage.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEImageUsageToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EBufferUsage createEBufferUsageFromString(EDataType eDataType, String initialValue)
	{
		EBufferUsage result = EBufferUsage.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEBufferUsageToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMemoryProperty createEMemoryPropertyFromString(EDataType eDataType, String initialValue)
	{
		EMemoryProperty result = EMemoryProperty.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEMemoryPropertyToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESampleCount createESampleCountFromString(EDataType eDataType, String initialValue)
	{
		ESampleCount result = ESampleCount.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '"
				+ initialValue
				+ "' is not a valid enumerator of '"
				+ eDataType.getName()
				+ "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertESampleCountToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumerationPackage getEnumerationPackage()
	{
		return (EnumerationPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EnumerationPackage getPackage()
	{
		return EnumerationPackage.eINSTANCE;
	}

} //EnumerationFactoryImpl
