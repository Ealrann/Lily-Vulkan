/**
 */
package org.sheepy.vulkan.model.image.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.vulkan.model.image.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImageFactoryImpl extends EFactoryImpl implements ImageFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImageFactory init()
	{
		try
		{
			ImageFactory theImageFactory = (ImageFactory)EPackage.Registry.INSTANCE.getEFactory(ImagePackage.eNS_URI);
			if (theImageFactory != null)
			{
				return theImageFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ImageFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageFactoryImpl()
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
			case ImagePackage.SAMPLER_INFO: return createSamplerInfo();
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
	public SamplerInfo createSamplerInfo()
	{
		SamplerInfoImpl samplerInfo = new SamplerInfoImpl();
		return samplerInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImagePackage getImagePackage()
	{
		return (ImagePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ImagePackage getPackage()
	{
		return ImagePackage.eINSTANCE;
	}

} //ImageFactoryImpl
