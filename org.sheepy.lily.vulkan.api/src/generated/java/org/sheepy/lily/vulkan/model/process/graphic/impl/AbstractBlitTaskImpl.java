/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.joml.Vector3ic;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.core.model.resource.IImage;

import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.model.process.graphic.AbstractBlitTask;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

import org.sheepy.vulkan.model.enumeration.EFilter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Blit Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AbstractBlitTaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AbstractBlitTaskImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AbstractBlitTaskImpl#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AbstractBlitTaskImpl#getClearColor <em>Clear Color</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AbstractBlitTaskImpl#getSrcImage <em>Src Image</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractBlitTaskImpl extends LilyEObject implements AbstractBlitTask
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getFilter() <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilter()
	 * @generated
	 * @ordered
	 */
	protected static final EFilter FILTER_EDEFAULT = EFilter.NEAREST;

	/**
	 * The cached value of the '{@link #getFilter() <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilter()
	 * @generated
	 * @ordered
	 */
	protected EFilter filter = FILTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getClearColor() <em>Clear Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClearColor()
	 * @generated
	 * @ordered
	 */
	protected static final Vector3ic CLEAR_COLOR_EDEFAULT = (Vector3ic)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector3i(), "0;0;0");

	/**
	 * The cached value of the '{@link #getClearColor() <em>Clear Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClearColor()
	 * @generated
	 * @ordered
	 */
	protected Vector3ic clearColor = CLEAR_COLOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSrcImage() <em>Src Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcImage()
	 * @generated
	 * @ordered
	 */
	protected IImage srcImage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractBlitTaskImpl()
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
		return GraphicPackage.Literals.ABSTRACT_BLIT_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.ABSTRACT_BLIT_TASK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.ABSTRACT_BLIT_TASK__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EFilter getFilter()
	{
		return filter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFilter(EFilter newFilter)
	{
		EFilter oldFilter = filter;
		filter = newFilter == null ? FILTER_EDEFAULT : newFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.ABSTRACT_BLIT_TASK__FILTER, oldFilter, filter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector3ic getClearColor()
	{
		return clearColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClearColor(Vector3ic newClearColor)
	{
		Vector3ic oldClearColor = clearColor;
		clearColor = newClearColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.ABSTRACT_BLIT_TASK__CLEAR_COLOR, oldClearColor, clearColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IImage getSrcImage()
	{
		if (srcImage != null && ((EObject)srcImage).eIsProxy())
		{
			InternalEObject oldSrcImage = srcImage;
			srcImage = (IImage)eResolveProxy(oldSrcImage);
			if (srcImage != oldSrcImage)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphicPackage.ABSTRACT_BLIT_TASK__SRC_IMAGE, oldSrcImage, srcImage));
			}
		}
		return srcImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IImage basicGetSrcImage()
	{
		return srcImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSrcImage(IImage newSrcImage)
	{
		IImage oldSrcImage = srcImage;
		srcImage = newSrcImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.ABSTRACT_BLIT_TASK__SRC_IMAGE, oldSrcImage, srcImage));
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
			case GraphicPackage.ABSTRACT_BLIT_TASK__NAME:
				return getName();
			case GraphicPackage.ABSTRACT_BLIT_TASK__ENABLED:
				return isEnabled();
			case GraphicPackage.ABSTRACT_BLIT_TASK__FILTER:
				return getFilter();
			case GraphicPackage.ABSTRACT_BLIT_TASK__CLEAR_COLOR:
				return getClearColor();
			case GraphicPackage.ABSTRACT_BLIT_TASK__SRC_IMAGE:
				if (resolve) return getSrcImage();
				return basicGetSrcImage();
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
			case GraphicPackage.ABSTRACT_BLIT_TASK__NAME:
				setName((String)newValue);
				return;
			case GraphicPackage.ABSTRACT_BLIT_TASK__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case GraphicPackage.ABSTRACT_BLIT_TASK__FILTER:
				setFilter((EFilter)newValue);
				return;
			case GraphicPackage.ABSTRACT_BLIT_TASK__CLEAR_COLOR:
				setClearColor((Vector3ic)newValue);
				return;
			case GraphicPackage.ABSTRACT_BLIT_TASK__SRC_IMAGE:
				setSrcImage((IImage)newValue);
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
			case GraphicPackage.ABSTRACT_BLIT_TASK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraphicPackage.ABSTRACT_BLIT_TASK__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case GraphicPackage.ABSTRACT_BLIT_TASK__FILTER:
				setFilter(FILTER_EDEFAULT);
				return;
			case GraphicPackage.ABSTRACT_BLIT_TASK__CLEAR_COLOR:
				setClearColor(CLEAR_COLOR_EDEFAULT);
				return;
			case GraphicPackage.ABSTRACT_BLIT_TASK__SRC_IMAGE:
				setSrcImage((IImage)null);
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
			case GraphicPackage.ABSTRACT_BLIT_TASK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GraphicPackage.ABSTRACT_BLIT_TASK__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case GraphicPackage.ABSTRACT_BLIT_TASK__FILTER:
				return filter != FILTER_EDEFAULT;
			case GraphicPackage.ABSTRACT_BLIT_TASK__CLEAR_COLOR:
				return CLEAR_COLOR_EDEFAULT == null ? clearColor != null : !CLEAR_COLOR_EDEFAULT.equals(clearColor);
			case GraphicPackage.ABSTRACT_BLIT_TASK__SRC_IMAGE:
				return srcImage != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", filter: ");
		result.append(filter);
		result.append(", clearColor: ");
		result.append(clearColor);
		result.append(')');
		return result.toString();
	}

} //AbstractBlitTaskImpl
