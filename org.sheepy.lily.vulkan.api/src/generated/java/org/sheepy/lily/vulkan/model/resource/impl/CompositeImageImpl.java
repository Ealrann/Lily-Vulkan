/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.vulkan.model.resource.CompositeImage;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.ImageInlay;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.CompositeImageImpl#getInlays <em>Inlays</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.CompositeImageImpl#getBackground <em>Background</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositeImageImpl extends ImageImpl implements CompositeImage
{
	/**
	 * The cached value of the '{@link #getInlays() <em>Inlays</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInlays()
	 * @generated
	 * @ordered
	 */
	protected EList<ImageInlay> inlays;

	/**
	 * The cached value of the '{@link #getBackground() <em>Background</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackground()
	 * @generated
	 * @ordered
	 */
	protected Image background;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeImageImpl()
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
		return VulkanResourcePackage.Literals.COMPOSITE_IMAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ImageInlay> getInlays()
	{
		if (inlays == null)
		{
			inlays = new EObjectContainmentEList<ImageInlay>(ImageInlay.class, this, VulkanResourcePackage.COMPOSITE_IMAGE__INLAYS);
		}
		return inlays;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Image getBackground()
	{
		if (background != null && ((EObject)background).eIsProxy())
		{
			InternalEObject oldBackground = background;
			background = (Image)eResolveProxy(oldBackground);
			if (background != oldBackground)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VulkanResourcePackage.COMPOSITE_IMAGE__BACKGROUND, oldBackground, background));
			}
		}
		return background;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Image basicGetBackground()
	{
		return background;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBackground(Image newBackground)
	{
		Image oldBackground = background;
		background = newBackground;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.COMPOSITE_IMAGE__BACKGROUND, oldBackground, background));
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
			case VulkanResourcePackage.COMPOSITE_IMAGE__INLAYS:
				return ((InternalEList<?>)getInlays()).basicRemove(otherEnd, msgs);
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
			case VulkanResourcePackage.COMPOSITE_IMAGE__INLAYS:
				return getInlays();
			case VulkanResourcePackage.COMPOSITE_IMAGE__BACKGROUND:
				if (resolve) return getBackground();
				return basicGetBackground();
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
			case VulkanResourcePackage.COMPOSITE_IMAGE__INLAYS:
				getInlays().clear();
				getInlays().addAll((Collection<? extends ImageInlay>)newValue);
				return;
			case VulkanResourcePackage.COMPOSITE_IMAGE__BACKGROUND:
				setBackground((Image)newValue);
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
			case VulkanResourcePackage.COMPOSITE_IMAGE__INLAYS:
				getInlays().clear();
				return;
			case VulkanResourcePackage.COMPOSITE_IMAGE__BACKGROUND:
				setBackground((Image)null);
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
			case VulkanResourcePackage.COMPOSITE_IMAGE__INLAYS:
				return inlays != null && !inlays.isEmpty();
			case VulkanResourcePackage.COMPOSITE_IMAGE__BACKGROUND:
				return background != null;
		}
		return super.eIsSet(featureID);
	}

} //CompositeImageImpl
