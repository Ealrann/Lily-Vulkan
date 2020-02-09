/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.model.resource.impl.IResourceImpl;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor;
import org.sheepy.lily.vulkan.model.resource.SampledImage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nuklear Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getFont <em>Font</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getNullTexture <em>Null Texture</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getLayoutTask <em>Layout Task</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getImageArrayDescriptor <em>Image Array Descriptor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NuklearContextImpl extends IResourceImpl implements NuklearContext
{
	/**
	 * The cached value of the '{@link #getFont() <em>Font</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFont()
	 * @generated
	 * @ordered
	 */
	protected NuklearFont font;

	/**
	 * The cached value of the '{@link #getNullTexture() <em>Null Texture</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNullTexture()
	 * @generated
	 * @ordered
	 */
	protected SampledImage nullTexture;

	/**
	 * The cached value of the '{@link #getLayoutTask() <em>Layout Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutTask()
	 * @generated
	 * @ordered
	 */
	protected NuklearLayoutTask layoutTask;

	/**
	 * The cached value of the '{@link #getImageArrayDescriptor() <em>Image Array Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageArrayDescriptor()
	 * @generated
	 * @ordered
	 */
	protected ImageArrayDescriptor imageArrayDescriptor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NuklearContextImpl()
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
		return NuklearPackage.Literals.NUKLEAR_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearFont getFont()
	{
		if (font != null && ((EObject)font).eIsProxy())
		{
			InternalEObject oldFont = font;
			font = (NuklearFont)eResolveProxy(oldFont);
			if (font != oldFont)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_CONTEXT__FONT, oldFont, font));
			}
		}
		return font;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuklearFont basicGetFont()
	{
		return font;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFont(NuklearFont newFont)
	{
		NuklearFont oldFont = font;
		font = newFont;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__FONT, oldFont, font));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SampledImage getNullTexture()
	{
		if (nullTexture != null && ((EObject)nullTexture).eIsProxy())
		{
			InternalEObject oldNullTexture = nullTexture;
			nullTexture = (SampledImage)eResolveProxy(oldNullTexture);
			if (nullTexture != oldNullTexture)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE, oldNullTexture, nullTexture));
			}
		}
		return nullTexture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SampledImage basicGetNullTexture()
	{
		return nullTexture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNullTexture(SampledImage newNullTexture)
	{
		SampledImage oldNullTexture = nullTexture;
		nullTexture = newNullTexture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE, oldNullTexture, nullTexture));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearLayoutTask getLayoutTask()
	{
		if (layoutTask != null && ((EObject)layoutTask).eIsProxy())
		{
			InternalEObject oldLayoutTask = layoutTask;
			layoutTask = (NuklearLayoutTask)eResolveProxy(oldLayoutTask);
			if (layoutTask != oldLayoutTask)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK, oldLayoutTask, layoutTask));
			}
		}
		return layoutTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuklearLayoutTask basicGetLayoutTask()
	{
		return layoutTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLayoutTask(NuklearLayoutTask newLayoutTask, NotificationChain msgs)
	{
		NuklearLayoutTask oldLayoutTask = layoutTask;
		layoutTask = newLayoutTask;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK, oldLayoutTask, newLayoutTask);
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
	public void setLayoutTask(NuklearLayoutTask newLayoutTask)
	{
		if (newLayoutTask != layoutTask)
		{
			NotificationChain msgs = null;
			if (layoutTask != null)
				msgs = ((InternalEObject)layoutTask).eInverseRemove(this, NuklearPackage.NUKLEAR_LAYOUT_TASK__CONTEXT, NuklearLayoutTask.class, msgs);
			if (newLayoutTask != null)
				msgs = ((InternalEObject)newLayoutTask).eInverseAdd(this, NuklearPackage.NUKLEAR_LAYOUT_TASK__CONTEXT, NuklearLayoutTask.class, msgs);
			msgs = basicSetLayoutTask(newLayoutTask, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK, newLayoutTask, newLayoutTask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageArrayDescriptor getImageArrayDescriptor()
	{
		if (imageArrayDescriptor != null && ((EObject)imageArrayDescriptor).eIsProxy())
		{
			InternalEObject oldImageArrayDescriptor = imageArrayDescriptor;
			imageArrayDescriptor = (ImageArrayDescriptor)eResolveProxy(oldImageArrayDescriptor);
			if (imageArrayDescriptor != oldImageArrayDescriptor)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_CONTEXT__IMAGE_ARRAY_DESCRIPTOR, oldImageArrayDescriptor, imageArrayDescriptor));
			}
		}
		return imageArrayDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageArrayDescriptor basicGetImageArrayDescriptor()
	{
		return imageArrayDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageArrayDescriptor(ImageArrayDescriptor newImageArrayDescriptor)
	{
		ImageArrayDescriptor oldImageArrayDescriptor = imageArrayDescriptor;
		imageArrayDescriptor = newImageArrayDescriptor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__IMAGE_ARRAY_DESCRIPTOR, oldImageArrayDescriptor, imageArrayDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK:
				if (layoutTask != null)
					msgs = ((InternalEObject)layoutTask).eInverseRemove(this, NuklearPackage.NUKLEAR_LAYOUT_TASK__CONTEXT, NuklearLayoutTask.class, msgs);
				return basicSetLayoutTask((NuklearLayoutTask)otherEnd, msgs);
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
			case NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK:
				return basicSetLayoutTask(null, msgs);
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
			case NuklearPackage.NUKLEAR_CONTEXT__FONT:
				if (resolve) return getFont();
				return basicGetFont();
			case NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE:
				if (resolve) return getNullTexture();
				return basicGetNullTexture();
			case NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK:
				if (resolve) return getLayoutTask();
				return basicGetLayoutTask();
			case NuklearPackage.NUKLEAR_CONTEXT__IMAGE_ARRAY_DESCRIPTOR:
				if (resolve) return getImageArrayDescriptor();
				return basicGetImageArrayDescriptor();
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
			case NuklearPackage.NUKLEAR_CONTEXT__FONT:
				setFont((NuklearFont)newValue);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE:
				setNullTexture((SampledImage)newValue);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK:
				setLayoutTask((NuklearLayoutTask)newValue);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__IMAGE_ARRAY_DESCRIPTOR:
				setImageArrayDescriptor((ImageArrayDescriptor)newValue);
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
			case NuklearPackage.NUKLEAR_CONTEXT__FONT:
				setFont((NuklearFont)null);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE:
				setNullTexture((SampledImage)null);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK:
				setLayoutTask((NuklearLayoutTask)null);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__IMAGE_ARRAY_DESCRIPTOR:
				setImageArrayDescriptor((ImageArrayDescriptor)null);
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
			case NuklearPackage.NUKLEAR_CONTEXT__FONT:
				return font != null;
			case NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE:
				return nullTexture != null;
			case NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK:
				return layoutTask != null;
			case NuklearPackage.NUKLEAR_CONTEXT__IMAGE_ARRAY_DESCRIPTOR:
				return imageArrayDescriptor != null;
		}
		return super.eIsSet(featureID);
	}

} //NuklearContextImpl
