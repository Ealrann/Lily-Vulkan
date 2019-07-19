/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

import org.sheepy.lily.vulkan.extra.model.sprite.Sprite;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage;
import org.sheepy.lily.vulkan.model.resource.PathResource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sprite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteImpl#getPresentedEntities <em>Presented Entities</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteImpl#getFile <em>File</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpriteImpl extends MinimalEObjectImpl.Container implements Sprite
{
	/**
	 * The cached value of the '{@link #getPresentedEntities() <em>Presented Entities</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentedEntities()
	 * @generated
	 * @ordered
	 */
	protected EList<PresentableEntity> presentedEntities;

	/**
	 * The cached value of the '{@link #getFile() <em>File</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected PathResource file;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpriteImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return SpritePackage.Literals.SPRITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PresentableEntity> getPresentedEntities()
	{
		if (presentedEntities == null)
		{
			presentedEntities = new EObjectWithInverseResolvingEList<PresentableEntity>(PresentableEntity.class, this, SpritePackage.SPRITE__PRESENTED_ENTITIES, RenderingPackage.PRESENTABLE_ENTITY__PRESENTATION);
		}
		return presentedEntities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PathResource getFile()
	{
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFile(PathResource newFile, NotificationChain msgs)
	{
		PathResource oldFile = file;
		file = newFile;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpritePackage.SPRITE__FILE, oldFile, newFile);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFile(PathResource newFile)
	{
		if (newFile != file)
		{
			NotificationChain msgs = null;
			if (file != null)
				msgs = ((InternalEObject)file).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpritePackage.SPRITE__FILE, null, msgs);
			if (newFile != null)
				msgs = ((InternalEObject)newFile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpritePackage.SPRITE__FILE, null, msgs);
			msgs = basicSetFile(newFile, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpritePackage.SPRITE__FILE, newFile, newFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case SpritePackage.SPRITE__PRESENTED_ENTITIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPresentedEntities()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case SpritePackage.SPRITE__PRESENTED_ENTITIES:
				return ((InternalEList<?>)getPresentedEntities()).basicRemove(otherEnd, msgs);
			case SpritePackage.SPRITE__FILE:
				return basicSetFile(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case SpritePackage.SPRITE__PRESENTED_ENTITIES:
				return getPresentedEntities();
			case SpritePackage.SPRITE__FILE:
				return getFile();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case SpritePackage.SPRITE__PRESENTED_ENTITIES:
				getPresentedEntities().clear();
				getPresentedEntities().addAll((Collection<? extends PresentableEntity>)newValue);
				return;
			case SpritePackage.SPRITE__FILE:
				setFile((PathResource)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case SpritePackage.SPRITE__PRESENTED_ENTITIES:
				getPresentedEntities().clear();
				return;
			case SpritePackage.SPRITE__FILE:
				setFile((PathResource)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case SpritePackage.SPRITE__PRESENTED_ENTITIES:
				return presentedEntities != null && !presentedEntities.isEmpty();
			case SpritePackage.SPRITE__FILE:
				return file != null;
		}
		return super.eIsSet(featureID);
	}

} //SpriteImpl
