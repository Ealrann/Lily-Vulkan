/**
 */
package org.sheepy.vulkan.model.enumeration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.vulkan.model.enumeration.*;

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
			EnumerationFactory theEnumerationFactory = (EnumerationFactory)EPackage.Registry.INSTANCE.getEFactory(EnumerationPackage.eNS_URI);
			if (theEnumerationFactory != null)
			{
				return theEnumerationFactory;
			}
		}
		catch (Exception exception)
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
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
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
			case EnumerationPackage.ECULL_MODE:
				return createECullModeFromString(eDataType, initialValue);
			case EnumerationPackage.EFRONT_FACE:
				return createEFrontFaceFromString(eDataType, initialValue);
			case EnumerationPackage.ECOMMAND_STAGE:
				return createECommandStageFromString(eDataType, initialValue);
			case EnumerationPackage.EATTACHMENT_LOAD_OP:
				return createEAttachmentLoadOpFromString(eDataType, initialValue);
			case EnumerationPackage.EATTACHMENT_STORE_OP:
				return createEAttachmentStoreOpFromString(eDataType, initialValue);
			case EnumerationPackage.ESHADER_STAGE:
				return createEShaderStageFromString(eDataType, initialValue);
			case EnumerationPackage.EPIPELINE_STAGE:
				return createEPipelineStageFromString(eDataType, initialValue);
			case EnumerationPackage.ECOLOR_SPACE:
				return createEColorSpaceFromString(eDataType, initialValue);
			case EnumerationPackage.EFORMAT:
				return createEFormatFromString(eDataType, initialValue);
			case EnumerationPackage.EPRESENT_MODE:
				return createEPresentModeFromString(eDataType, initialValue);
			case EnumerationPackage.EIMAGE_USAGE:
				return createEImageUsageFromString(eDataType, initialValue);
			case EnumerationPackage.ESAMPLE_COUNT:
				return createESampleCountFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
			case EnumerationPackage.ECULL_MODE:
				return convertECullModeToString(eDataType, instanceValue);
			case EnumerationPackage.EFRONT_FACE:
				return convertEFrontFaceToString(eDataType, instanceValue);
			case EnumerationPackage.ECOMMAND_STAGE:
				return convertECommandStageToString(eDataType, instanceValue);
			case EnumerationPackage.EATTACHMENT_LOAD_OP:
				return convertEAttachmentLoadOpToString(eDataType, instanceValue);
			case EnumerationPackage.EATTACHMENT_STORE_OP:
				return convertEAttachmentStoreOpToString(eDataType, instanceValue);
			case EnumerationPackage.ESHADER_STAGE:
				return convertEShaderStageToString(eDataType, instanceValue);
			case EnumerationPackage.EPIPELINE_STAGE:
				return convertEPipelineStageToString(eDataType, instanceValue);
			case EnumerationPackage.ECOLOR_SPACE:
				return convertEColorSpaceToString(eDataType, instanceValue);
			case EnumerationPackage.EFORMAT:
				return convertEFormatToString(eDataType, instanceValue);
			case EnumerationPackage.EPRESENT_MODE:
				return convertEPresentModeToString(eDataType, instanceValue);
			case EnumerationPackage.EIMAGE_USAGE:
				return convertEImageUsageToString(eDataType, instanceValue);
			case EnumerationPackage.ESAMPLE_COUNT:
				return convertESampleCountToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public ECullMode createECullModeFromString(EDataType eDataType, String initialValue)
	{
		ECullMode result = ECullMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public EFrontFace createEFrontFaceFromString(EDataType eDataType, String initialValue)
	{
		EFrontFace result = EFrontFace.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public ECommandStage createECommandStageFromString(EDataType eDataType, String initialValue)
	{
		ECommandStage result = ECommandStage.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public EAttachmentLoadOp createEAttachmentLoadOpFromString(EDataType eDataType, String initialValue)
	{
		EAttachmentLoadOp result = EAttachmentLoadOp.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public EAttachmentStoreOp createEAttachmentStoreOpFromString(EDataType eDataType, String initialValue)
	{
		EAttachmentStoreOp result = EAttachmentStoreOp.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public EPipelineStage createEPipelineStageFromString(EDataType eDataType, String initialValue)
	{
		EPipelineStage result = EPipelineStage.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public EImageUsage createEImageUsageFromString(EDataType eDataType, String initialValue)
	{
		EImageUsage result = EImageUsage.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public ESampleCount createESampleCountFromString(EDataType eDataType, String initialValue)
	{
		ESampleCount result = ESampleCount.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public EnumerationPackage getEnumerationPackage()
	{
		return (EnumerationPackage)getEPackage();
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
