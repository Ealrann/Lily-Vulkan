/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteFactory;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpriteFactoryImpl extends EFactoryImpl implements SpriteFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SpriteFactory init()
	{
		try
		{
			SpriteFactory theSpriteFactory = (SpriteFactory)EPackage.Registry.INSTANCE.getEFactory(SpritePackage.eNS_URI);
			if (theSpriteFactory != null)
			{
				return theSpriteFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SpriteFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpriteFactoryImpl()
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
			case SpritePackage.SPRITE_EXTENSION: return (EObject)createSpriteExtension();
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
	public SpriteExtension createSpriteExtension()
	{
		SpriteExtensionImpl spriteExtension = new SpriteExtensionImpl();
		return spriteExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpritePackage getSpritePackage()
	{
		return (SpritePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SpritePackage getPackage()
	{
		return SpritePackage.eINSTANCE;
	}

} //SpriteFactoryImpl
