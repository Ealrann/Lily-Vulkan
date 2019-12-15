/**
 */
package org.sheepy.lily.vulkan.model.binding.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.vulkan.model.binding.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BindingFactoryImpl extends EFactoryImpl implements BindingFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BindingFactory init()
	{
		try
		{
			BindingFactory theBindingFactory = (BindingFactory)EPackage.Registry.INSTANCE.getEFactory(BindingPackage.eNS_URI);
			if (theBindingFactory != null)
			{
				return theBindingFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BindingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingFactoryImpl()
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
			case BindingPackage.BINDING_CONFIGURATION: return createBindingConfiguration();
			case BindingPackage.CONFIGURE_BIND: return createConfigureBind();
			case BindingPackage.ROTATE_CONFIGURATION: return createRotateConfiguration();
			case BindingPackage.CONFIGURE_PREPARE_COMPOSITE: return createConfigurePrepareComposite();
			case BindingPackage.CONFIGURE_COMPOSITE_BUFFER_BARRIER: return createConfigureCompositeBufferBarrier();
			case BindingPackage.INDEX_CONFIGURATION: return createIndexConfiguration();
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
			case BindingPackage.EINSTANCE:
				return createEInstanceFromString(eDataType, initialValue);
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
			case BindingPackage.EINSTANCE:
				return convertEInstanceToString(eDataType, instanceValue);
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
	public BindingConfiguration createBindingConfiguration()
	{
		BindingConfigurationImpl bindingConfiguration = new BindingConfigurationImpl();
		return bindingConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConfigureBind createConfigureBind()
	{
		ConfigureBindImpl configureBind = new ConfigureBindImpl();
		return configureBind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RotateConfiguration createRotateConfiguration()
	{
		RotateConfigurationImpl rotateConfiguration = new RotateConfigurationImpl();
		return rotateConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConfigurePrepareComposite createConfigurePrepareComposite()
	{
		ConfigurePrepareCompositeImpl configurePrepareComposite = new ConfigurePrepareCompositeImpl();
		return configurePrepareComposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConfigureCompositeBufferBarrier createConfigureCompositeBufferBarrier()
	{
		ConfigureCompositeBufferBarrierImpl configureCompositeBufferBarrier = new ConfigureCompositeBufferBarrierImpl();
		return configureCompositeBufferBarrier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IndexConfiguration createIndexConfiguration()
	{
		IndexConfigurationImpl indexConfiguration = new IndexConfigurationImpl();
		return indexConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EInstance createEInstanceFromString(EDataType eDataType, String initialValue)
	{
		EInstance result = EInstance.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEInstanceToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BindingPackage getBindingPackage()
	{
		return (BindingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BindingPackage getPackage()
	{
		return BindingPackage.eINSTANCE;
	}

} //BindingFactoryImpl
