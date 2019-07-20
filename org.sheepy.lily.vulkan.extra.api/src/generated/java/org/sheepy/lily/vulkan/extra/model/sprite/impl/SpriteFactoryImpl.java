/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.vulkan.extra.model.sprite.*;

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
			case SpritePackage.SPRITE_RENDERER: return createSpriteRenderer();
			case SpritePackage.SPRITE: return createSprite();
			case SpritePackage.SPRITE_PKG: return createSpritePkg();
			case SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER: return createSpriteMonoSamplerProvider();
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
	public SpriteRenderer createSpriteRenderer()
	{
		SpriteRendererImpl spriteRenderer = new SpriteRendererImpl();
		return spriteRenderer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Sprite createSprite()
	{
		SpriteImpl sprite = new SpriteImpl();
		return sprite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpritePkg createSpritePkg()
	{
		SpritePkgImpl spritePkg = new SpritePkgImpl();
		return spritePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpriteMonoSamplerProvider createSpriteMonoSamplerProvider()
	{
		SpriteMonoSamplerProviderImpl spriteMonoSamplerProvider = new SpriteMonoSamplerProviderImpl();
		return spriteMonoSamplerProvider;
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
