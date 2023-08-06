/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.vulkan.extra.model.rendering.Camera;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraVariable;
import org.sheepy.lily.vulkan.extra.model.rendering.ECameraField;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Camera Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.CameraVariableImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.CameraVariableImpl#getCamera <em>Camera</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.CameraVariableImpl#getField <em>Field</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CameraVariableImpl extends LilyEObject implements CameraVariable
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
	 * The cached value of the '{@link #getCamera() <em>Camera</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCamera()
	 * @generated
	 * @ordered
	 */
	protected Camera camera;

	/**
	 * The default value of the '{@link #getField() <em>Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField()
	 * @generated
	 * @ordered
	 */
	protected static final ECameraField FIELD_EDEFAULT = ECameraField.ZNEAR;

	/**
	 * The cached value of the '{@link #getField() <em>Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField()
	 * @generated
	 * @ordered
	 */
	protected ECameraField field = FIELD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CameraVariableImpl()
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
		return RenderingPackage.Literals.CAMERA_VARIABLE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.CAMERA_VARIABLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Camera getCamera()
	{
		if (camera != null && ((EObject)camera).eIsProxy())
		{
			InternalEObject oldCamera = camera;
			camera = (Camera)eResolveProxy(oldCamera);
			if (camera != oldCamera)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderingPackage.CAMERA_VARIABLE__CAMERA, oldCamera, camera));
			}
		}
		return camera;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Camera basicGetCamera()
	{
		return camera;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCamera(Camera newCamera)
	{
		Camera oldCamera = camera;
		camera = newCamera;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.CAMERA_VARIABLE__CAMERA, oldCamera, camera));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ECameraField getField()
	{
		return field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setField(ECameraField newField)
	{
		ECameraField oldField = field;
		field = newField == null ? FIELD_EDEFAULT : newField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.CAMERA_VARIABLE__FIELD, oldField, field));
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
			case RenderingPackage.CAMERA_VARIABLE__NAME:
				return getName();
			case RenderingPackage.CAMERA_VARIABLE__CAMERA:
				if (resolve) return getCamera();
				return basicGetCamera();
			case RenderingPackage.CAMERA_VARIABLE__FIELD:
				return getField();
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
			case RenderingPackage.CAMERA_VARIABLE__NAME:
				setName((String)newValue);
				return;
			case RenderingPackage.CAMERA_VARIABLE__CAMERA:
				setCamera((Camera)newValue);
				return;
			case RenderingPackage.CAMERA_VARIABLE__FIELD:
				setField((ECameraField)newValue);
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
			case RenderingPackage.CAMERA_VARIABLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RenderingPackage.CAMERA_VARIABLE__CAMERA:
				setCamera((Camera)null);
				return;
			case RenderingPackage.CAMERA_VARIABLE__FIELD:
				setField(FIELD_EDEFAULT);
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
			case RenderingPackage.CAMERA_VARIABLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RenderingPackage.CAMERA_VARIABLE__CAMERA:
				return camera != null;
			case RenderingPackage.CAMERA_VARIABLE__FIELD:
				return field != FIELD_EDEFAULT;
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
		result.append(", field: ");
		result.append(field);
		result.append(')');
		return result.toString();
	}

} //CameraVariableImpl
