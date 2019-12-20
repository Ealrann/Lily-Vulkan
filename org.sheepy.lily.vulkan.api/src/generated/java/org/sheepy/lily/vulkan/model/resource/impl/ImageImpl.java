/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.model.application.impl.IResourceImpl;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.model.image.ImageLayout;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.ImageImpl#getInitialLayout <em>Initial Layout</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ImageImpl extends IResourceImpl implements Image
{
	/**
	 * The cached value of the '{@link #getInitialLayout() <em>Initial Layout</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialLayout()
	 * @generated
	 * @ordered
	 */
	protected ImageLayout initialLayout;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImageImpl()
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
		return ResourcePackage.Literals.IMAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageLayout getInitialLayout()
	{
		return initialLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialLayout(ImageLayout newInitialLayout, NotificationChain msgs)
	{
		ImageLayout oldInitialLayout = initialLayout;
		initialLayout = newInitialLayout;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResourcePackage.IMAGE__INITIAL_LAYOUT, oldInitialLayout, newInitialLayout);
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
	public void setInitialLayout(ImageLayout newInitialLayout)
	{
		if (newInitialLayout != initialLayout)
		{
			NotificationChain msgs = null;
			if (initialLayout != null)
				msgs = ((InternalEObject)initialLayout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResourcePackage.IMAGE__INITIAL_LAYOUT, null, msgs);
			if (newInitialLayout != null)
				msgs = ((InternalEObject)newInitialLayout).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResourcePackage.IMAGE__INITIAL_LAYOUT, null, msgs);
			msgs = basicSetInitialLayout(newInitialLayout, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.IMAGE__INITIAL_LAYOUT, newInitialLayout, newInitialLayout));
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
			case ResourcePackage.IMAGE__INITIAL_LAYOUT:
				return basicSetInitialLayout(null, msgs);
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
			case ResourcePackage.IMAGE__INITIAL_LAYOUT:
				return getInitialLayout();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ResourcePackage.IMAGE__INITIAL_LAYOUT:
				setInitialLayout((ImageLayout)newValue);
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
			case ResourcePackage.IMAGE__INITIAL_LAYOUT:
				setInitialLayout((ImageLayout)null);
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
			case ResourcePackage.IMAGE__INITIAL_LAYOUT:
				return initialLayout != null;
		}
		return super.eIsSet(featureID);
	}

} //ImageImpl
